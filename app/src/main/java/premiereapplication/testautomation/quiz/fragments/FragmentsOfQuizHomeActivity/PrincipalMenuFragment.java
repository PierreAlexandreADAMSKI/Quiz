package premiereapplication.testautomation.quiz.fragments.FragmentsOfQuizHomeActivity;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import premiereapplication.testautomation.quiz.R;
import premiereapplication.testautomation.quiz.interfaces.QuizHomeActivityListener;

public class PrincipalMenuFragment extends Fragment {

    private QuizHomeActivityListener mListener;
    private CardView staticQuizCardView;
    private CardView dynamicQuizCardView;
    private CardView resultsListCardView;

    public PrincipalMenuFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof QuizHomeActivityListener) {
            mListener = (QuizHomeActivityListener) activity;
        }
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_principal_menu, container, false);

        staticQuizCardView = (CardView) rootView.findViewById(R.id.static_quiz_card_view);
        staticQuizCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mListener.moveToListOfStaticQuizFragment();


            }

        });


        dynamicQuizCardView = (CardView) rootView.findViewById(R.id.dynamic_quiz_card_view);
        dynamicQuizCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mListener.moveToListOfDynamicQuizFragment();


            }

        });

        resultsListCardView = (CardView) rootView.findViewById(R.id.results_list_card_view);
        resultsListCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mListener.moveToListOfResultsFragment();


            }

        });


        return rootView;
    }


}
