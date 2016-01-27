package premiereapplication.testautomation.quiz.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by isen on 25/01/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    // The current database version
    private static final int DATABASE_VERSION = 11;

    // The current database name
    private static final String DATABASE_NAME = "quizResults.db";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataBaseContract.TABLE_RESULTS_CREATE_SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseContract.TABLE_RESULTS);
        onCreate(db);
    }
}
