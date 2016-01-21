package premiereapplication.testautomation.quiz.Async;

import android.os.AsyncTask;

import java.util.List;

import premiereapplication.testautomation.quiz.aplication.QuizApplication;
import premiereapplication.testautomation.quiz.helpers.HelperFileToListQuiz;
import premiereapplication.testautomation.quiz.helpers.QuizHelper;
import premiereapplication.testautomation.quiz.interfaces.QuizRetrievedListener;

/**
 * Created by User on 19/01/2016.
 */
public class RetrieveQuizsFromLocalServerAsyncTask extends AsyncTask<String, Void, List<QuizHelper>> {


    private QuizRetrievedListener mListener;

    public RetrieveQuizsFromLocalServerAsyncTask(QuizRetrievedListener listener){
        mListener = listener;
    }

    @Override
    protected List<QuizHelper> doInBackground(String... params) {

        return HelperFileToListQuiz.getListOfQuizFromFile(QuizApplication.getContext());
    }

    @Override
    protected void onPostExecute(List<QuizHelper> result) {


        if (null != mListener && null != result){
            mListener.onQuizRetrieved(result);


        }

    }








}
