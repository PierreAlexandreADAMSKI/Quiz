package premiereapplication.testautomation.quiz.fragments.FragmentsOfQuizHomeActivity;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import premiereapplication.testautomation.quiz.DataBase.DataBaseManager;
import premiereapplication.testautomation.quiz.R;
import premiereapplication.testautomation.quiz.adapters.ListQuizAdapter;
import premiereapplication.testautomation.quiz.adapters.ScoreAdapter;
import premiereapplication.testautomation.quiz.application.QuizApplication;
import premiereapplication.testautomation.quiz.helpers.QuizHelper;
import premiereapplication.testautomation.quiz.interfaces.QuizHomeActivityListener;
import premiereapplication.testautomation.quiz.interfaces.QuizActivityListener;
import premiereapplication.testautomation.quiz.objects.Score;

public class ListOfResultsFragment extends Fragment {

    private QuizHomeActivityListener mListener;

    private RecyclerView recyclerView;


    public ListOfResultsFragment(){}

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof QuizActivityListener){
            mListener = (QuizHomeActivityListener) activity;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_list_of_results, container, false);

        List<Score> listScore = DataBaseManager.scoreHelper(); // TODO

        recyclerView = (RecyclerView) rootView.findViewById(R.id.resultRecyclerView);// change id.quizsListView to <RecyclerView>
        final LinearLayoutManager layoutManager = new LinearLayoutManager(QuizApplication.getContext()); //, LinearLayoutManager.vertical, false);
        this.recyclerView.setLayoutManager(layoutManager);

        final ScoreAdapter scoreAdapter = new ScoreAdapter(listScore, mListener);
        recyclerView.setAdapter(scoreAdapter);

        return rootView;
    }

}
