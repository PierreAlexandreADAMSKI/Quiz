package premiereapplication.testautomation.quiz.activities;


import android.app.Activity;
import android.os.Bundle;

import premiereapplication.testautomation.quiz.R;
import premiereapplication.testautomation.quiz.fragments.FragmentsOfQuizActivity.ChronoAndHeaderQuizFragment;
import premiereapplication.testautomation.quiz.fragments.FragmentsOfQuizActivity.EndQuizFragment;
import premiereapplication.testautomation.quiz.fragments.FragmentsOfQuizActivity.QuizFragment;
import premiereapplication.testautomation.quiz.interfaces.ChronoAndHeaderQuizFragmentListener;
import premiereapplication.testautomation.quiz.interfaces.QuizActivityListener;
import premiereapplication.testautomation.quiz.objects.ObjectQuiz;

public class QuizActivity extends Activity  implements QuizActivityListener {


    private static  int indexQuestion;
    private static  int score;
    private static ObjectQuiz quizToLaunch;
    private ChronoAndHeaderQuizFragmentListener mlistener;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        indexQuestion =0;
        score=0;
        quizToLaunch = (ObjectQuiz)getIntent().getExtras().getSerializable("QuizToLaunch");

        QuizFragment quizFragment =QuizFragment.getInstance(quizToLaunch,0);
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
        if(indexQuestion <quizToLaunch.listQuestionPropositionsAnswers.size()){
            QuizFragment quizFragment =QuizFragment.getInstance(quizToLaunch, indexQuestion);
            getFragmentManager().beginTransaction().replace(R.id.container, quizFragment).commit();
        }

        else{

            mlistener.stopChronometer();
            onQuizEnd(mlistener.getTime().split(":")[1],false);
        }
    }


    public void onQuizEnd(String time,boolean isTimeOut) {

        String yourScore=Integer.toString(score)+"/"+Integer.toString(quizToLaunch.listQuestionPropositionsAnswers.size());
        EndQuizFragment endQuizFragment=EndQuizFragment.getInstance(isTimeOut,quizToLaunch.nameOfQuiz,yourScore,time);
        getFragmentManager().beginTransaction().replace(R.id.container,endQuizFragment).commit();

    }


    @Override
    public void finishActivity() {

        finish();
    }


}
