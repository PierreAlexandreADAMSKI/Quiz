package premiereapplication.testautomation.quiz.fragments.FragmentsOfQuizActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.TextView;

import premiereapplication.testautomation.quiz.R;
import premiereapplication.testautomation.quiz.helpers.QuizHelper;
import premiereapplication.testautomation.quiz.interfaces.ChronoAndHeaderQuizFragmentListener;
import premiereapplication.testautomation.quiz.interfaces.QuizActivityListener;


public class ChronoAndHeaderQuizFragment extends android.app.Fragment implements Chronometer.OnChronometerTickListener,ChronoAndHeaderQuizFragmentListener {


    private TextView nameQuizTextView;
    private TextView timerQuizTextView;
    private Chronometer chronometer;
    private String timeOut;

    private static QuizHelper quizToLaunch;
    private QuizActivityListener mListener;

    public ChronoAndHeaderQuizFragment() {}


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof QuizActivityListener){
            mListener = (QuizActivityListener) activity;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_chrono_and_header_quiz, container, false);
        quizToLaunch = (QuizHelper) getArguments().getSerializable("QuizToLaunch");

          nameQuizTextView =(TextView) rootView.findViewById(R.id.nomQuizLaunchedTextView);
          nameQuizTextView.setText("Quiz " + quizToLaunch.getName());

          timerQuizTextView =(TextView) rootView.findViewById(R.id.dureeQuizLaunchedTextView);
          timerQuizTextView.setText(quizToLaunch.getSec() + " sec");
          timeOut="00:"+quizToLaunch.getSec().toString();


         chronometer = (Chronometer) rootView.findViewById(R.id.chronometer);
         //chronometer.setFormat("ss");
         chronometer.setOnChronometerTickListener(this);

        return rootView;

    }

    @Override
    public void onStart() {
        super.onStart();
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();
    }

    public void onChronometerTick(Chronometer chronometer) {

        if (timeOut.equals(chronometer.getText())) {
            mListener.onQuizEnd(Integer.toString(quizToLaunch.getSec()),true);
            chronometer.stop();
        }
    }


    @Override
    public void stopChronometer() {
    chronometer.stop();
    }

    @Override
    public String getTime() {
        return chronometer.getText().toString();
    }


    public static ChronoAndHeaderQuizFragment getInstance(QuizHelper quiz){

        ChronoAndHeaderQuizFragment chronoAndHeaderQuizFragment =new ChronoAndHeaderQuizFragment();
        Bundle bundle=new Bundle();
        bundle.putSerializable("QuizToLaunch", quiz);
        chronoAndHeaderQuizFragment.setArguments(bundle);
        return chronoAndHeaderQuizFragment;
    }


}

