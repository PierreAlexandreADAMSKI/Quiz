package premiereapplication.testautomation.quiz.dynamicServer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class TwitterHelper {

	// Proxy stuff
	private static final boolean USE_PROXY = false;
	private static final String PROXY_HOST = "prx-dev02.priv.atos.fr";
	private static final int PROXY_PORT = 3128;
	private static final boolean USE_PROXY_AUTHENTICATION = false;
	private static final String PROXY_USERNAME = "training10";
	private static final String PROXY_PASSWORD = "Student10/";

	public static List<Tweet> getTweetsOfUser(String userName){
		try {
			// Step 1: Encode consumer key and secret
			final String urlApiKey = URLEncoder.encode(Constants.Twitter.API_KEY, "UTF-8");
			final String urlApiSecret = URLEncoder.encode(Constants.Twitter.API_SECRET, "UTF-8");

			// Concatenate the encoded consumer key, a colon character, and the
			// encoded consumer secret
			final String combined = urlApiKey + ":" + urlApiSecret;

			// Base64 encode the string
			final String base64Encoded = Base64.encodeToString(combined.getBytes(), Base64.NO_WRAP);

			// Retrieve the raw authorization token from Twitter
			final TwitterAuthenticated auth = getTwitterAuthentication(base64Encoded);

			// Applications should verify that the value associated with the
			// token_type key of the returned object is bearer
			if ((null != auth) && (null != auth.token_type) && (auth.token_type.equals("bearer"))) {
				return getTweets(userName, auth.access_token);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return getFakeTweets();
	}

	public static Bitmap getTwitterUserImage(String imageUrl) throws Exception {
		final HttpURLConnection connection = getHTTPUrlConnection(imageUrl);
		connection.setRequestMethod("GET");
		connection.setRequestProperty("User-Agent", "Mozilla/5.0");

		final int responseCode = connection.getResponseCode();

		// If success
		if (responseCode == 200){
			final Bitmap bitmap = BitmapFactory.decodeStream(connection.getInputStream());
			return bitmap;
		}
		return null;
	}

	private static List<Tweet> getTweets(String userName, String bearer) throws Exception {
		// Create the HTTP Get request to Twitter servers
		final HttpURLConnection connection = getHTTPUrlConnection(Constants.Twitter.URL_STREAM + userName);
		connection.setRequestMethod("GET");
		connection.setRequestProperty("User-Agent", "Mozilla/5.0");
		connection.setRequestProperty("Authorization", "Bearer " + bearer);
		connection.setRequestProperty("Content-Type", "application/json");

		final int responseCode = connection.getResponseCode();

		// If success
		if (responseCode == 200){
			// Build our Tweet list
			final Type type = new TypeToken<ArrayList<Tweet>>() {}.getType();
			return new Gson().fromJson(new JsonReader(new InputStreamReader(connection.getInputStream(), "UTF-8")), type);
		}

		return getFakeTweets();
	}

	private static TwitterAuthenticated getTwitterAuthentication(String base64Encoded) throws Exception {
		// Create a HTTP Post to twitter platform
		final HttpURLConnection conn =  getHTTPUrlConnection(Constants.Twitter.URL_TOKEN);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("User-Agent", "Mozilla/5.0");
		conn.setRequestProperty("Authorization", "Basic " + base64Encoded);
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");

		// Send post request
		conn.setDoOutput(true);
		final DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		wr.writeBytes("grant_type=client_credentials");
		wr.flush();
		wr.close();

		final int responseCode = conn.getResponseCode();
		// If success
		if (responseCode == 200){
			// Read the response, and build the TwitterAuthenticated object
			final TwitterAuthenticated authenticated = new Gson().fromJson(new JsonReader(new InputStreamReader(conn.getInputStream(), "UTF-8")), TwitterAuthenticated.class);
			return authenticated;
		}

		return null;
	}


	private static HttpURLConnection getHTTPUrlConnection(String url) throws Exception {
		if (USE_PROXY){
			final Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_HOST, PROXY_PORT));

			if (USE_PROXY_AUTHENTICATION){
				Authenticator authenticator = new Authenticator() {
					public PasswordAuthentication getPasswordAuthentication() {
						return (new PasswordAuthentication(PROXY_USERNAME, PROXY_PASSWORD.toCharArray()));
					}
				};
				Authenticator.setDefault(authenticator);
			}

			return (HttpURLConnection) new URL(url).openConnection(proxy);
		} else {
			return (HttpURLConnection) new URL(url).openConnection();
		}
	}


	public static List<Tweet> getFakeTweets() {
		final ArrayList<Tweet> tweets = new ArrayList<Tweet>();

		// Build a TwitterUser
		TwitterUser user = new TwitterUser();
		user.name = "R&D Worldline";
		user.screenName = "rd_aw";
		user.profileImageUrl = "";

		// Build 20 Tweets
		for(int i=0; i<20; i++) {
			final Tweet tweet = new Tweet();
			tweet.text = "Tweet #" + i;
			tweet.user = user;
			tweets.add(tweet);
		}
		return tweets;
	}

	static public List<ObjectQuiz> getListOfQuizsFromTwitter(String s) {


		List<ObjectQuiz> listObjetQuiz = new ArrayList<ObjectQuiz>();

		String arrayOfQuizs[] = s.split("Quiz");

		for (int i = 0; i < arrayOfQuizs.length; i++) {
			String quizName = arrayOfQuizs[i].split("//")[0];
			int quizDuration = Integer.parseInt(arrayOfQuizs[i].split("//")[1]);
			List<QuestionPropositionsAnswers> listeQuestionPropositionsAnsewers = new ArrayList<QuestionPropositionsAnswers>();

			String arrayQustionPropositionsAnsewers[] = arrayOfQuizs[i].split("//")[2].split("&gt;");
			for (int j = 0; j < arrayQustionPropositionsAnsewers.length; j++) {
				String enonceQuestion = arrayQustionPropositionsAnsewers[j].split("&lt;")[0];
				List<String> listPropositions = new ArrayList<String>();
				List<String> listAnsewers = new ArrayList<String>();

				String PropositionsAnsewers = arrayQustionPropositionsAnsewers[j].split("&lt;")[1];
				String arrayPropositions[] = PropositionsAnsewers.split("/")[0].split(",");
				String arrayAnsewers[] = PropositionsAnsewers.split("/")[1].split(",");
				for (int n = 0; n < arrayPropositions.length; n++) {
					listPropositions.add(arrayPropositions[n]);
				}
				for (int n = 0; n < arrayAnsewers.length; n++) {
					listAnsewers.add(arrayAnsewers[n]);
				}
				QuestionPropositionsAnswers qpr = new QuestionPropositionsAnswers(enonceQuestion, listPropositions, listAnsewers);
				listeQuestionPropositionsAnsewers.add(qpr);


			}

			ObjectQuiz oq = new ObjectQuiz(quizName, quizDuration, listeQuestionPropositionsAnsewers);
			listObjetQuiz.add(oq);
		}

		return listObjetQuiz;
	}














}
