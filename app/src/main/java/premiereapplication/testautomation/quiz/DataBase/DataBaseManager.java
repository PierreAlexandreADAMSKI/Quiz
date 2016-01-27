package premiereapplication.testautomation.quiz.DataBase;

import android.content.ContentValues;
import android.database.Cursor;
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

    public static void makeDB(int timeResult, int quizTime, String score, String quizName) {
        //recuperation
        String id = PreferenceUtils.getStoredLogin();
        // writing data base
        final SQLiteDatabase resultsDB = sqLiteOpenHelper.getWritableDatabase();
        final ContentValues contentValues = new ContentValues();

        contentValues.put(DataBaseContract.TIME_RESULT, timeResult);
        contentValues.put(DataBaseContract.SCORE, score);
        contentValues.put(DataBaseContract.QUIZ_NAME, quizName);
        contentValues.put(DataBaseContract.QUIZ_TIME, quizTime);


        resultsDB.insert(DataBaseContract.TABLE_RESULTS, "", contentValues);

        // Now that all values are stored in database, read them  and print

    }

    public static List<Score> scoreHelper() {
        List<Score> listScore = new ArrayList<>();
        final SQLiteDatabase resultsDB = sqLiteOpenHelper.getWritableDatabase();
        //TODO order by best scores query should work but doesn't???
        final Cursor cursor = resultsDB.query(DataBaseContract.TABLE_RESULTS,
                DataBaseContract.PROJECTION_PART,
                null, null, DataBaseContract.QUIZ_NAME, null, DataBaseContract.SCORE);
        if (null != cursor) {
            while (cursor.moveToNext()) {
                final Score score = new Score();
                if (cursor.getColumnIndex(DataBaseContract.QUIZ_NAME) >= 0) {
                    score.setName(cursor.getString(cursor.getColumnIndex(DataBaseContract.QUIZ_NAME)));
                }
                if (cursor.getColumnIndex(DataBaseContract.QUIZ_TIME) >= 0) {
                    score.setQuizTime(cursor.getInt(cursor.getColumnIndex(DataBaseContract.QUIZ_TIME)));
                }
                if (cursor.getColumnIndex(DataBaseContract.TIME_RESULT) >= 0) {
                    score.setTimeResult(cursor.getInt(cursor.getColumnIndex(DataBaseContract.TIME_RESULT)));
                }
                if (cursor.getColumnIndex(DataBaseContract.SCORE) >= 0) {
                    score.setScore(cursor.getString(cursor.getColumnIndex(DataBaseContract.SCORE)));
                }
                listScore.add(score);
            }
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }
        return listScore;
    }
}
