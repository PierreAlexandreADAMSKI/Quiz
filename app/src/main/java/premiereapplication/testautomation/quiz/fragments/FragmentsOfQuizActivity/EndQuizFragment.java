package premiereapplication.testautomation.quiz.fragments.FragmentsOfQuizActivity;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import premiereapplication.testautomation.quiz.R;
import premiereapplication.testautomation.quiz.interfaces.QuizActivityListener;
import premiereapplication.testautomation.quiz.utils.PreferenceUtils;

public class EndQuizFragment extends Fragment {


    private Button exitButton;
    private TextView loginTextView;
    private TextView scoreTextView;
    private TextView timeTextView;
    private TextView end_sentence;

    private QuizActivityListener mListener;
    private Boolean isTimeOut;
    private String nameOfQuiz;
    private String score;
    private int time;

    public EndQuizFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof QuizActivityListener) {
            mListener = (QuizActivityListener) activity;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_end_quiz, container, false);

        isTimeOut = getArguments().getBoolean("IsTimeOut");
        nameOfQuiz = getArguments().getString("NameOfQuiz");
        score = getArguments().getString("Score");
        time = getArguments().getInt("Time");

        end_sentence = (TextView) rootView.findViewById(R.id.end_sentence);
        if (isTimeOut) {
         end_sentence.setText("Time is out !");
        }


        loginTextView = (TextView) rootView.findViewById(R.id.loginTextView);
        loginTextView.setText("Login: " + PreferenceUtils.getStoredLogin());

        scoreTextView = (TextView) rootView.findViewById(R.id.scoreTextView);
        scoreTextView.setText("Score: " + score);

        timeTextView = (TextView) rootView.findViewById(R.id.timeTextView);
        timeTextView.setText("Time: " + time + " sec");


        exitButton = (Button) rootView.findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.finishActivity();
            }

        });


        return rootView;
    }


    public static EndQuizFragment getInstance(Boolean isTimeOut, String nameOfQuiz, String score, int time) {

        EndQuizFragment endQuizFragment = new EndQuizFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("IsTimeOut", isTimeOut);
        bundle.putString("NameOfQuiz", nameOfQuiz);
        bundle.putString("Score", score);
        bundle.putInt("Time", time);
        endQuizFragment.setArguments(bundle);
        return endQuizFragment;
    }

}
