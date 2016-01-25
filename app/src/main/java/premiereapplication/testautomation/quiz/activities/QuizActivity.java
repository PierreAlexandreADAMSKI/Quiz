package premiereapplication.testautomation.quiz.activities;


import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;

import premiereapplication.testautomation.quiz.DataBase.DataBaseManager;
import premiereapplication.testautomation.quiz.R;
import premiereapplication.testautomation.quiz.fragments.FragmentsOfQuizActivity.ChronoAndHeaderQuizFragment;
import premiereapplication.testautomation.quiz.fragments.FragmentsOfQuizActivity.EndQuizFragment;
import premiereapplication.testautomation.quiz.fragments.FragmentsOfQuizActivity.QuizFragment;
import premiereapplication.testautomation.quiz.helpers.QuizHelper;
import premiereapplication.testautomation.quiz.interfaces.ChronoAndHeaderQuizFragmentListener;
import premiereapplication.testautomation.quiz.interfaces.QuizActivityListener;

public class QuizActivity extends Activity  implements QuizActivityListener {


    private static  int indexQuestion;
    private static  int score;
    private static QuizHelper quizToLaunch;
    private ChronoAndHeaderQuizFragmentListener mlistener;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        indexQuestion =0;
        score=0;
        quizToLaunch = (QuizHelper)getIntent().getExtras().getSerializable("QuizToLaunch");

        QuizFragment quizFragment = QuizFragment.getInstance(quizToLaunch,0);
        ChronoAndHeaderQuizFragment chronoAndHeaderQuizFragment = ChronoAndHeaderQuizFragment.getInstance(quizToLaunch);
        mlistener= chronoAndHeaderQuizFragment;

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.headerContainer, chronoAndHeaderQuizFragment).commit();
            getFragmentManager().beginTransaction().add(R.id.container, quizFragment).commit();
        }

    }

    @Override
    public void scoreIncrementation() {
        score++;
    }


    @Override
    public void nextQuestion() {
        indexQuestion++;
        if(indexQuestion <quizToLaunch.getQuestions().size()){
            QuizFragment quizFragment =QuizFragment.getInstance(quizToLaunch, indexQuestion);
            getFragmentManager().beginTransaction().replace(R.id.container, quizFragment).commit();
        }

        else{

            mlistener.stopChronometer();
            onQuizEnd(mlistener.getTime(),false);
        }
    }


    public void onQuizEnd(int time,boolean isTimeOut) {

        String yourScore=Integer.toString(score)+"/"+Integer.toString(quizToLaunch.getQuestions().size());
        EndQuizFragment endQuizFragment=EndQuizFragment.getInstance(isTimeOut,quizToLaunch.getName(),yourScore,time);
        getFragmentManager().beginTransaction().replace(R.id.container,endQuizFragment).commit();

        DataBaseManager.makeDB(time, yourScore);


    }


    @Override
    public void finishActivity() {

        finish();
    }


}
