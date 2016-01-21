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
import android.widget.Toast;

import java.util.List;

import premiereapplication.testautomation.quiz.Async.RetrieveQuizFromLocalServerAsyncTask;
import premiereapplication.testautomation.quiz.Async.RetrieveQuizFromTwitterAsyncTask;
import premiereapplication.testautomation.quiz.R;
import premiereapplication.testautomation.quiz.adapters.ListQuizAdapter;
import premiereapplication.testautomation.quiz.aplication.QuizApplication;
import premiereapplication.testautomation.quiz.decoration.SpacesItemDecoration;
import premiereapplication.testautomation.quiz.helpers.QuizHelper;
import premiereapplication.testautomation.quiz.interfaces.QuizActivityListener;
import premiereapplication.testautomation.quiz.interfaces.QuizHomeActivityListener;
import premiereapplication.testautomation.quiz.interfaces.QuizRetrievedListener;


public class ListOfQuizsFragment extends Fragment implements QuizRetrievedListener {

    private static final int DIVIDER_HEIGHT = 40;

    private QuizHomeActivityListener mListener;
    private RecyclerView recyclerView;
    private boolean isDynamicQuiz;
    private RetrieveQuizFromTwitterAsyncTask mDynamicQuizsAsynTask;
    private RetrieveQuizFromLocalServerAsyncTask mStaticQuizsAsyntask;

    public ListOfQuizsFragment(){}

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

        View rootView = inflater.inflate(R.layout.fragment_list_of_quizs, container, false);

        isDynamicQuiz = getArguments().getBoolean("IsDynamicQuiz");
        recyclerView = (RecyclerView) rootView.findViewById(R.id.quizsListView);// change id.quizsListView to <RecyclerView>
        final LinearLayoutManager layoutManager = new LinearLayoutManager(QuizApplication.getContext());
        this.recyclerView.setLayoutManager(layoutManager);
        this.recyclerView.addItemDecoration(new SpacesItemDecoration(DIVIDER_HEIGHT));

        // Set a Progress Bar as empty view, and display it (set adapter with no elements))
        final ProgressBar progressBar = new ProgressBar(getActivity());
        progressBar.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
        progressBar.setIndeterminate(true);
        //recyclerView.setEmptyView(progressBar);

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        if(isDynamicQuiz) {
            mDynamicQuizsAsynTask = new RetrieveQuizFromTwitterAsyncTask(this);
            mDynamicQuizsAsynTask.execute("@madaniachraf2");
        }
        else{
            mStaticQuizsAsyntask= new RetrieveQuizFromLocalServerAsyncTask(this);
            mStaticQuizsAsyntask.execute();

        }
    }


    @Override
    public void onQuizRetrieved(List<QuizHelper> listOfQuiz) {

        try {
            final ListQuizAdapter listQuizAdapter = new ListQuizAdapter(listOfQuiz, mListener);
            recyclerView.setAdapter(listQuizAdapter);

        }catch(Exception e){

            if(isDynamicQuiz) {
                Toast.makeText(QuizApplication.getContext(), "Un probleme est survenu dans le serveur dynamique", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(QuizApplication.getContext(), "Un probleme est survenu dans le serveur statique", Toast.LENGTH_SHORT).show();
            }
        }
        mDynamicQuizsAsynTask = null;
        mStaticQuizsAsyntask = null;

    }

    public static ListOfQuizsFragment getInstance(boolean isDynamicQuiz){

        ListOfQuizsFragment listOfQuizsFragmentquizFragment =new ListOfQuizsFragment();
        Bundle bundle=new Bundle();
        bundle.putBoolean("IsDynamicQuiz",isDynamicQuiz);
        listOfQuizsFragmentquizFragment.setArguments(bundle);

        return listOfQuizsFragmentquizFragment;
    }



}



