package premiereapplication.testautomation.quiz.Async;

import android.os.AsyncTask;

import java.util.List;

import premiereapplication.testautomation.quiz.aplication.QuizApplication;
import premiereapplication.testautomation.quiz.helpers.HelperFileToListQuiz;
import premiereapplication.testautomation.quiz.interfaces.QuizsRetrievedListener;
import premiereapplication.testautomation.quiz.objects.ObjectQuiz;

/**
 * Created by User on 19/01/2016.
 */
public class RetrieveQuizsFromLocalServerAsyncTask extends AsyncTask<String, Void, List<ObjectQuiz>> {


    private QuizsRetrievedListener mListener;

    public RetrieveQuizsFromLocalServerAsyncTask(QuizsRetrievedListener listener){
        mListener = listener;
    }

    @Override
    protected List<ObjectQuiz> doInBackground(String... params) {

        return HelperFileToListQuiz.getListOfQuizsFromFile(QuizApplication.getContext());
    }

    @Override
    protected void onPostExecute(List<ObjectQuiz> result) {


        if (null != mListener && null != result){
            mListener.onQuizRetrieved(result);


        }

    }








}
