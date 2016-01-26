package premiereapplication.testautomation.quiz.utils;

import android.content.Context;
import android.content.SharedPreferences;




/**
 * Created by User on 22/01/2016.
 */
public class TimeUtils {


    public static  int  timeToSeconds(String time){ // time in format mm:ss

    return (Integer.parseInt(time.split(":")[0])*60)+Integer.parseInt(time.split(":")[1]);
    }


}
