package premiereapplication.testautomation.quiz.objects;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by isen on 24/01/2016.
 */
public class Score implements Serializable {

    public String score;
    public int time;

    public Score(){

    }
    public Score(int time, String yourScore){

    }

     public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Score{" +
                "score=" + score +
                ", time=" + time +
                '}';
    }
}
