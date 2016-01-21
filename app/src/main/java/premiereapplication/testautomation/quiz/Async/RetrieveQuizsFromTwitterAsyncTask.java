package premiereapplication.testautomation.quiz.Async;

import android.os.AsyncTask;

import java.util.List;

import premiereapplication.testautomation.quiz.objects.ObjectQuiz;
import premiereapplication.testautomation.quiz.dynamicServer.Tweet;
import premiereapplication.testautomation.quiz.interfaces.QuizsRetrievedListener;
import premiereapplication.testautomation.quiz.dynamicServer.TwitterHelper;

public class RetrieveQuizsFromTwitterAsyncTask extends AsyncTask<String, Void, List<ObjectQuiz>> {

	// A reference to the listener
	private QuizsRetrievedListener mListener;
	
	public RetrieveQuizsFromTwitterAsyncTask(QuizsRetrievedListener listener){
		mListener = listener;
	}
	
	@Override
	protected List<ObjectQuiz> doInBackground(String... params) {
		if ((null != params) && (params.length > 0)){

			List<Tweet> tweets= TwitterHelper.getTweetsOfUser(params[0]);
			String quizFromTwitter ="";
			int index=tweets.size()-1;

			while(index>-1){
				quizFromTwitter = quizFromTwitter +tweets.get(index).text;
				index--;
			}

			return TwitterHelper.getListOfQuizsFromTwitter(quizFromTwitter);

		}
		return null;
	}

	@Override
	protected void onPostExecute(List<ObjectQuiz> result) {


		if (null != mListener && null != result){
			mListener.onQuizRetrieved(result);


		}

	}
	
}
