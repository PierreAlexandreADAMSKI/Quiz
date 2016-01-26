package premiereapplication.testautomation.quiz.fragments.FragmentsOfQuizHomeActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

import premiereapplication.testautomation.quiz.Async.RetrieveQuizFromLocalServerAsyncTask;
import premiereapplication.testautomation.quiz.Async.RetrieveQuizFromTwitterAsyncTask;
import premiereapplication.testautomation.quiz.R;
import premiereapplication.testautomation.quiz.adapters.ListQuizAdapter;
import premiereapplication.testautomation.quiz.application.QuizApplication;
import premiereapplication.testautomation.quiz.helpers.QuizHelper;
import premiereapplication.testautomation.quiz.interfaces.QuizHomeActivityListener;
import premiereapplication.testautomation.quiz.interfaces.QuizRetrievedListener;


public class ListOfQuizFragment extends Fragment  {

    private static final int DIVIDER_HEIGHT = 40;

    private QuizHomeActivityListener mListener;
    private TextView categoryTitleTextView;
    private RecyclerView recyclerView;
    private boolean isDynamicQuiz;


    public ListOfQuizFragment(){}

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof QuizHomeActivityListener){
            mListener = (QuizHomeActivityListener) activity;
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_list_of_quizs, container, false);

        isDynamicQuiz = getArguments().getBoolean("IsDynamicQuiz");
        List<QuizHelper> lisOfQuizsForThisFragment= (List<QuizHelper>) getArguments().getSerializable("ListOfQuizOfForThisFragment");

        String categoryTitle = getArguments().getString("CategoryTitle");
        categoryTitleTextView=(TextView) rootView.findViewById(R.id.categoryTitle);
        categoryTitleTextView.setText(categoryTitle);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.quizListView);// change id.quizsListView to <RecyclerView>
        final LinearLayoutManager layoutManager = new LinearLayoutManager(QuizApplication.getContext(),LinearLayoutManager.HORIZONTAL,false); //, LinearLayoutManager.HORIZONTAL, false);
        this.verticalRecyclerView.setLayoutManager(layoutManager);

        final ListQuizAdapter listQuizAdapter = new ListQuizAdapter(lisOfQuizsForThisFragment, mListener);
        recyclerView.setAdapter(listQuizAdapter);


        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();


    }




    public static ListOfQuizFragment getInstance(boolean isDynamicQuiz,String categoryTitle,List <QuizHelper> listOfQuizsForThisFragment ){

        ListOfQuizFragment listOfQuizsFragmentquizFragment =new ListOfQuizFragment();
        Bundle bundle=new Bundle();
        bundle.putBoolean("IsDynamicQuiz", isDynamicQuiz);
        bundle.putString("CategoryTitle",categoryTitle);
        bundle.putSerializable("ListOfQuizOfForThisFragment", (Serializable) listOfQuizsForThisFragment);
        listOfQuizsFragmentquizFragment.setArguments(bundle);

        return listOfQuizsFragmentquizFragment;
    }



}



