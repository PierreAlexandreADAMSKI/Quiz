package premiereapplication.testautomation.quiz.fragments.FragmentsOfQuizActivity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import premiereapplication.testautomation.quiz.R;
import premiereapplication.testautomation.quiz.adapters.AnswersAdapter;
import premiereapplication.testautomation.quiz.helpers.QuizHelper;
import premiereapplication.testautomation.quiz.interfaces.QuizActivityListener;
import premiereapplication.testautomation.quiz.objects.Question;


public class QuizFragment extends Fragment {

    private QuizActivityListener activityListener;

    public QuizFragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_quiz, container, false);

        //TODO check setSerializable()
        final QuizHelper quizToLaunch = (QuizHelper) getArguments().getSerializable("QuizToLaunch");
        final int indexQuestion = getArguments().getInt("IndexQuestionEnCours");

        assert quizToLaunch != null;
        Question currentQuestion = quizToLaunch.getQuestions().get(indexQuestion);


        TextView questionTextView = (TextView) rootView.findViewById(R.id.questionTextView);
        //TODO change id to recyclerview
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.propositionsListView);
        recyclerView.setAdapter(new AnswersAdapter(currentQuestion.getAnswers(), activityListener));

        questionTextView.setText(currentQuestion.getQuestion());

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof QuizActivityListener){
            activityListener = (QuizActivityListener) activity;
        }
    }


    public static QuizFragment getInstance(ObjectQuiz quiz,int indexquestion){

        QuizFragment quizFragment =new QuizFragment();
        Bundle bundle=new Bundle();
        bundle.putSerializable("QuizToLaunch", quiz);
        bundle.putInt("IndexQuestionEnCours", indexquestion);
        quizFragment.setArguments(bundle);

        return quizFragment;
    }
}
