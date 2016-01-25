package premiereapplication.testautomation.quiz.DataBase;

import android.provider.BaseColumns;

/**
 * Created by isen on 25/01/2016.
 */
public class DataBaseContract implements BaseColumns {
    // Field names
    public static final String ID = "iD";
    public static final String TIME = "time";
    public static final String SCORE = "score";


    // Table name
    public static final String TABLE_RESULTS = "results";

    // Table scripts creation
    private static final String TABLE_GENERIC_CREATE_SCRIPT_PREFIX = "CREATE TABLE IF NOT EXISTS ";
    private static final String TABLE_IMAGES_CREATE_SCRIPT_SUFFIX = "(" + _ID + " INTEGER PRIMARY KEY, " +
            ID + " TEXT NOT NULL, "+
            TIME + " TEXT NOT NULL, "+
            SCORE+ " TEXT NOT NULL)";

    public static final String TABLE_RESULTS_CREATE_SCRIPT = TABLE_GENERIC_CREATE_SCRIPT_PREFIX +
            TABLE_RESULTS + TABLE_IMAGES_CREATE_SCRIPT_SUFFIX;

    // The projections
    public static final String[] PROJECTION_FULL = new String[]{
            _ID,
            ID,
            TIME,
            SCORE
    };

    // Selections
    public static final String SELECTION_BY_ID = _ID + "=?";
    public static final String SELECTION_BY_SCORE = SCORE + "=?";
    public static final String SELECTION_BY_USER_NAME = ID + "=?";

    // Sort order
    //public static final String ORDER_BY_DATE_CREATED_TIMESTAMP_DESCENDING = DATE_CREATED_TIMESTAMP + " DESC";

    // Content Provider stuff
    // public static final String CONTENT_PROVIDER_TWEETS_AUTHORITY = "worldline.ssm.rd.ux.TweetAuthority";
    //public static final Uri TWEETS_URI = Uri.parse("content://" + CONTENT_PROVIDER_TWEETS_AUTHORITY + "/" + TABLE_TWEETS);
    //public static final String TWEETS_CONTENT_TYPE = "vnd.android.cursor.dir/vnd.wltwitter.tweets";


}


