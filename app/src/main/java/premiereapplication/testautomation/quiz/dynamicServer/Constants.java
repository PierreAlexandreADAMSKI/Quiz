package premiereapplication.testautomation.quiz.dynamicServer;

public class Constants {

	public class General {
		public static final String LOG_TAG = "WLTwitter";
	}
	
	public class Twitter {
		public static final String URL_TOKEN = "https://api.twitter.com/oauth2/token";
		public static final String URL_STREAM = "https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=";

		public static final String API_KEY = "zVbBgGOX1XWqmUFXAPN5A3xrb";
		public static final String API_SECRET = "YNLBrvGSNXZs4H8Thpjz3isCS6UqAH3u2gyG7zHpBzYhiJLTiW";
		public static final String DEFAULT_USERNAME = "rd_aw";
	}

	public class Tweet {
		public static final String EXTRA_Name = "extraName";
		public static final String EXTRA_Alias = "extraAlias";
		public static final String EXTRA_Text = "extraText";
	}
	
}
