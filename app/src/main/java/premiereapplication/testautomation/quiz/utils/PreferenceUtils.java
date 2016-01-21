package premiereapplication.testautomation.quiz.utils;

import android.content.Context;
import android.content.SharedPreferences;

import premiereapplication.testautomation.quiz.aplication.QuizApplication;


public class PreferenceUtils {

	public static void setLogin(String login){
		final SharedPreferences prefs = QuizApplication.getContext().getSharedPreferences("QuizSharedPrefs", Context.MODE_PRIVATE);
		prefs.edit().putString("Pref_login", login).commit();
	}


	public static String getStoredLogin(){
		final SharedPreferences prefs = QuizApplication.getContext().getSharedPreferences("QuizSharedPrefs", Context.MODE_PRIVATE);
		return prefs.getString("Pref_login", null);
	}
}
