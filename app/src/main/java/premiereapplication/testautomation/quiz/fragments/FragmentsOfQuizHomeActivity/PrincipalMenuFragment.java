package premiereapplication.testautomation.quiz.fragments.FragmentsOfQuizHomeActivity;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import premiereapplication.testautomation.quiz.R;
import premiereapplication.testautomation.quiz.application.QuizApplication;
import premiereapplication.testautomation.quiz.helpers.HelperFileToListQuiz;
import premiereapplication.testautomation.quiz.helpers.QuizHelper;
import premiereapplication.testautomation.quiz.interfaces.QuizHomeActivityListener;

public class PrincipalMenuFragment extends Fragment{

    private Button listOfStaticQuizsButton;
    private Button listOfDynamicQuizsButton;
    private Button listOfResultsButton;
    private QuizHomeActivityListener mListener;

    public PrincipalMenuFragment(){}

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof QuizHomeActivityListener){
            mListener = (QuizHomeActivityListener) activity;
        }
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_principal_menu, container, false);

        listOfStaticQuizsButton = (Button) rootView.findViewById(R.id.staticQuizsButton);
        listOfStaticQuizsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mListener.moveToListOfStaticQuizFragment();

            }

        });

        listOfDynamicQuizsButton = (Button) rootView.findViewById(R.id.dynamicQuizsButton);
        listOfDynamicQuizsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mListener.moveToListOfDynamicQuizFragment();
            }

        });




        listOfResultsButton =(Button) rootView.findViewById(R.id.resultsQuizsButton);
        listOfResultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mListener.moveToListOfResultsFragment();
            }

        });

        return rootView;
    }



}
