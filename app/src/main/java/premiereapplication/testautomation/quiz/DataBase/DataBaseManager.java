package premiereapplication.testautomation.quiz.DataBase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import premiereapplication.testautomation.quiz.application.QuizApplication;
import premiereapplication.testautomation.quiz.objects.Score;
import premiereapplication.testautomation.quiz.utils.PreferenceUtils;

/**
 * Created by isen on 25/01/2016.
 */
public class DataBaseManager {

    static final SQLiteOpenHelper sqLiteOpenHelper = new DataBaseHelper(QuizApplication.getContext());
    final SQLiteDatabase resultsDB = sqLiteOpenHelper.getWritableDatabase();

    public static void  makeDB (int time, String score) {
        //recuperation
        String id = PreferenceUtils.getStoredLogin();
        // writing data base
        final SQLiteDatabase resultsDB = sqLiteOpenHelper.getWritableDatabase();
        final ContentValues contentValues = new ContentValues();

        contentValues.put(DataBaseContract.ID, id);
        contentValues.put(DataBaseContract.TIME, time);
        contentValues.put(DataBaseContract.SCORE, score);

        resultsDB.insert(DataBaseContract.TABLE_RESULTS, "", contentValues);

        // Now that all values are stored in database, read them  and print

    }

    public static Score scoreFromCursor(Cursor cursor){

        //unused yet
        String l = "";

        Score score = new Score();
        if (null != cursor)

        {
            while (cursor.moveToNext()) {

                if (cursor.getColumnIndex(DataBaseContract.ID) >= 0) {
                    l = cursor.getString(cursor.getColumnIndex(DataBaseContract.ID));
                }
                if (cursor.getColumnIndex(DataBaseContract.TIME) >= 0) {
                    score.time = cursor.getInt(cursor.getColumnIndex(DataBaseContract.TIME));
                }
                if (cursor.getColumnIndex(DataBaseContract.SCORE) >= 0) {
                    score.score = cursor.getString(cursor.getColumnIndex(DataBaseContract.SCORE));
                }
            }
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }
        return score;
    }



    public static List<Score> scoreHelper() {
        List<Score> listScore = new ArrayList<>();
        final SQLiteDatabase resultsDB = sqLiteOpenHelper.getWritableDatabase();
        final Cursor cursor = resultsDB.query(DataBaseContract.TABLE_RESULTS,
                DataBaseContract.PROJECTION_PART,
                null, null, null, null, null);
        for (int i = 0; i < cursor.getCount(); i++ ){
            listScore.add(scoreFromCursor(cursor));
        }

        return listScore;
    }

}
