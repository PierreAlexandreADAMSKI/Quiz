package premiereapplication.testautomation.quiz.fragments.FragmentsOfQuizHomeActivity;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import premiereapplication.testautomation.quiz.Async.RetrieveQuizFromLocalServerAsyncTask;
import premiereapplication.testautomation.quiz.Async.RetrieveQuizFromTwitterAsyncTask;
import premiereapplication.testautomation.quiz.R;
import premiereapplication.testautomation.quiz.helpers.CategoryHelper;
import premiereapplication.testautomation.quiz.helpers.QuizHelper;
import premiereapplication.testautomation.quiz.interfaces.QuizHomeActivityListener;
import premiereapplication.testautomation.quiz.interfaces.QuizRetrievedListener;

public class GlobalListOfQuizFragment extends Fragment implements QuizRetrievedListener {

    private QuizHomeActivityListener mListener;
    private RetrieveQuizFromTwitterAsyncTask mDynamicQuizAsyncTask;
    private RetrieveQuizFromLocalServerAsyncTask mStaticQuizAsyncTask;
    private boolean isDynamicQuiz;

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

        isDynamicQuiz=getArguments().getBoolean("IsDynamicQuiz");
        View rootView = inflater.inflate(R.layout.fragment_global_list_of_quizs, container, false);

        return rootView;
    }


    public void onStart() {
        super.onStart();
        if(isDynamicQuiz) {
            mDynamicQuizAsyncTask = new RetrieveQuizFromTwitterAsyncTask(this);
            mDynamicQuizAsyncTask.execute("@madaniachraf2");
        }
        else{
            mStaticQuizAsyncTask = new RetrieveQuizFromLocalServerAsyncTask(this);
            mStaticQuizAsyncTask.execute();
        }


    }



    @Override
    public void onQuizRetrieved(CategoryHelper categoryHelper) {

        if(categoryHelper !=null) {

            bindContainers(isDynamicQuiz,categoryHelper.CINEMA.getList(),categoryHelper.CULTURE_GENERALE.getList(),
                    categoryHelper.SPORT.getList(),categoryHelper.MUSIQUE.getList(),categoryHelper.LITERATURE.getList(),
                    categoryHelper.Divers.getList());}


        mDynamicQuizAsyncTask = null;
        mStaticQuizAsyncTask = null;

    }

    public static GlobalListOfQuizFragment getInstance(boolean isDynamicQuiz){

        GlobalListOfQuizFragment globalListOfQuizsFragmentquizFragment = new GlobalListOfQuizFragment();
        Bundle bundle=new Bundle();
        bundle.putBoolean("IsDynamicQuiz",isDynamicQuiz);
        globalListOfQuizsFragmentquizFragment.setArguments(bundle);

        return globalListOfQuizsFragmentquizFragment;
    }

    public void bindContainers(boolean isDynamiqueQuiz,List<QuizHelper>...list){

        ListOfQuizFragment frag= ListOfQuizFragment.getInstance(isDynamiqueQuiz,"Cinema",list[0]);
        getFragmentManager().beginTransaction().add(R.id.container1, frag).commit();

        ListOfQuizFragment frag2= ListOfQuizFragment.getInstance(isDynamiqueQuiz,"Culture Generale",list[1]);
        getFragmentManager().beginTransaction().add(R.id.container2, frag2).commit();

        ListOfQuizFragment frag3= ListOfQuizFragment.getInstance(isDynamiqueQuiz,"Sport",list[2]);
        getFragmentManager().beginTransaction().add(R.id.container3, frag3).commit();

        ListOfQuizFragment frag4= ListOfQuizFragment.getInstance(isDynamiqueQuiz,"Musique",list[3]);
        getFragmentManager().beginTransaction().add(R.id.container4, frag4).commit();

        ListOfQuizFragment frag5= ListOfQuizFragment.getInstance(isDynamiqueQuiz,"Literature",list[4]);
        getFragmentManager().beginTransaction().add(R.id.container5, frag5).commit();

        ListOfQuizFragment frag6= ListOfQuizFragment.getInstance(isDynamiqueQuiz,"Divers",list[5]);
        getFragmentManager().beginTransaction().add(R.id.container6, frag6).commit();




    }



}

