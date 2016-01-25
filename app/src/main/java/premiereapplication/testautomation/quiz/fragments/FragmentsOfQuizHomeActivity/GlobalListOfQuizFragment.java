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

import premiereapplication.testautomation.quiz.Async.RetrieveQuizFromLocalServerAsyncTask;
import premiereapplication.testautomation.quiz.Async.RetrieveQuizFromTwitterAsyncTask;
import premiereapplication.testautomation.quiz.R;
import premiereapplication.testautomation.quiz.application.QuizApplication;
import premiereapplication.testautomation.quiz.interfaces.QuizHomeActivityListener;

public class GlobalListOfQuizFragment extends Fragment {

    private QuizHomeActivityListener mListener;
    public GlobalListOfQuizFragment(){}

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

        View rootView = inflater.inflate(R.layout.fragment_global_list_of_quizs, container, false);

        return rootView;
    }


    public void onStart() {
        super.onStart();
         ListOfQuizFragment frag= ListOfQuizFragment.getInstance(false);
         getFragmentManager().beginTransaction().add(R.id.container1, frag).commit();

         ListOfQuizFragment frag2= ListOfQuizFragment.getInstance(false);
         getFragmentManager().beginTransaction().add(R.id.container2, frag2).commit();

        ListOfQuizFragment frag3= ListOfQuizFragment.getInstance(false);
        getFragmentManager().beginTransaction().add(R.id.container3, frag3).commit();

        ListOfQuizFragment frag4= ListOfQuizFragment.getInstance(false);
        getFragmentManager().beginTransaction().add(R.id.container4, frag4).commit();

        ListOfQuizFragment frag5= ListOfQuizFragment.getInstance(false);
        getFragmentManager().beginTransaction().add(R.id.container5, frag5).commit();

        ListOfQuizFragment frag6= ListOfQuizFragment.getInstance(false);
        getFragmentManager().beginTransaction().add(R.id.container5, frag6).commit();


    }




}
