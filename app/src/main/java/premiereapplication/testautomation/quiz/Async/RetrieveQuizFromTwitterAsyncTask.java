package premiereapplication.testautomation.quiz.Async;

import android.os.AsyncTask;
import android.widget.Toast;

import java.util.List;

import premiereapplication.testautomation.quiz.application.QuizApplication;
import premiereapplication.testautomation.quiz.dynamicServer.Tweet;
import premiereapplication.testautomation.quiz.dynamicServer.TwitterHelper;
import premiereapplication.testautomation.quiz.helpers.QuizHelper;
import premiereapplication.testautomation.quiz.interfaces.QuizRetrievedListener;

public class RetrieveQuizFromTwitterAsyncTask extends AsyncTask<String, Void, List<QuizHelper>> {

	// A reference to the listener
	private QuizRetrievedListener mListener;
	
	public RetrieveQuizFromTwitterAsyncTask(QuizRetrievedListener listener){
		mListener = listener;
	}
	
	@Override
	protected List<QuizHelper> doInBackground(String... params) {
		if ((null != params) && (params.length > 0)){

			List<Tweet> tweets = TwitterHelper.getTweetsOfUser(params[0]);
			String quizFromTwitter ="";
			int index=tweets.size()-1;

			while(index>-1){
				quizFromTwitter = quizFromTwitter +tweets.get(index).text;
				index--;
			}

			List<QuizHelper> listQuizs=null;

			try{
				listQuizs= TwitterHelper.getListOfQuizsFromTwitter(quizFromTwitter);
			}
			catch(Exception e){
				Toast.makeText(QuizApplication.getContext(), "Check your dynamic server !", Toast.LENGTH_SHORT).show();
			}

			finally{ return listQuizs;}

		}
		return null;
	}

	@Override
	protected void onPostExecute(List<QuizHelper> result) {


		if (null != mListener && null != result){
			mListener.onQuizRetrieved(result);


		}

	}
	
}
