package premiereapplication.testautomation.quiz.Async;

import android.os.AsyncTask;
import android.widget.Toast;

import java.util.List;

import premiereapplication.testautomation.quiz.application.QuizApplication;
import premiereapplication.testautomation.quiz.helpers.HelperFileToListQuiz;
import premiereapplication.testautomation.quiz.helpers.QuizHelper;
import premiereapplication.testautomation.quiz.interfaces.QuizRetrievedListener;

/**
 * Created by User on 19/01/2016.
 */
public class RetrieveQuizFromLocalServerAsyncTask extends AsyncTask<String, Void, List<QuizHelper>> {


    private QuizRetrievedListener mListener;

    public RetrieveQuizFromLocalServerAsyncTask(QuizRetrievedListener listener){
        mListener = listener;
    }

    @Override
    protected List<QuizHelper> doInBackground(String... params) {

        List<QuizHelper> listQuizs=null;

        try{
            listQuizs= HelperFileToListQuiz.getListOfQuizFromFile(QuizApplication.getContext());
        }
        catch(Exception e){
            Toast.makeText(QuizApplication.getContext(), "Check your local server !", Toast.LENGTH_SHORT).show();
        }

        finally{ return listQuizs;}

    }

    @Override
    protected void onPostExecute(List<QuizHelper> result) {


        if (null != mListener && null != result){
            mListener.onQuizRetrieved(result);


        }

    }








}
