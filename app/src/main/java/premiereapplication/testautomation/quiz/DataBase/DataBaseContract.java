package premiereapplication.testautomation.quiz.DataBase;

import android.provider.BaseColumns;

/**
 * Created by isen on 25/01/2016.
 */
public class DataBaseContract implements BaseColumns {
    // Field names
    public static final String TIME_RESULT = "time";
    public static final String SCORE = "score";
    public static final String QUIZ_TIME = "quizTime";
    public static final String QUIZ_NAME = "quizName";


    // Table name
    public static final String TABLE_RESULTS = "results";

    // Table scripts creation
    private static final String TABLE_GENERIC_CREATE_SCRIPT_PREFIX = "CREATE TABLE IF NOT EXISTS ";
    private static final String TABLE_IMAGES_CREATE_SCRIPT_SUFFIX = "(" + _ID + " INTEGER PRIMARY KEY, " +
            QUIZ_NAME + " TEXT NOT NULL, "+
            QUIZ_TIME + " TEXT NOT NULL, "+
            TIME_RESULT + " TEXT NOT NULL, "+
            SCORE+ " TEXT NOT NULL)";

    public static final String TABLE_RESULTS_CREATE_SCRIPT = TABLE_GENERIC_CREATE_SCRIPT_PREFIX +
            TABLE_RESULTS + TABLE_IMAGES_CREATE_SCRIPT_SUFFIX;

    // The projections
    public static final String[] PROJECTION_PART = new String[]{
            QUIZ_NAME,
            QUIZ_TIME,
            TIME_RESULT,
            SCORE
    };


    // Selections
    public static final String SELECTION_BY_QUIZ_NAME = QUIZ_NAME + "=?";

    // Sort order
    //public static final String ORDER_BY_DATE_CREATED_TIMESTAMP_DESCENDING = DATE_CREATED_TIMESTAMP + " DESC";

    // Content Provider stuff
    // public static final String CONTENT_PROVIDER_TWEETS_AUTHORITY = "worldline.ssm.rd.ux.TweetAuthority";
    //public static final Uri TWEETS_URI = Uri.parse("content://" + CONTENT_PROVIDER_TWEETS_AUTHORITY + "/" + TABLE_TWEETS);
    //public static final String TWEETS_CONTENT_TYPE = "vnd.android.cursor.dir/vnd.wltwitter.tweets";


}


