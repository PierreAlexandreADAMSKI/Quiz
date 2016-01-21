package premiereapplication.testautomation.quiz.fragments.FragmentsOfQuizHomeActivity;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import premiereapplication.testautomation.quiz.R;
import premiereapplication.testautomation.quiz.interfaces.QuizHomeActivityListener;
import premiereapplication.testautomation.quiz.interfaces.QuizActivityListener;

public class ListOfResultsFragment extends Fragment {

    private QuizHomeActivityListener mListener;

    public ListOfResultsFragment(){}

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof QuizActivityListener){
            mListener = (QuizHomeActivityListener) activity;
        }
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_list_of_results, container, false);


        return rootView;
    }



}
