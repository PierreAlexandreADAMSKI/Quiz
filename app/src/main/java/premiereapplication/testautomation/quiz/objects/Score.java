package premiereapplication.testautomation.quiz.objects;

import java.io.Serializable;

/**
 * Created by isen on 24/01/2016.
 */
public class Score implements Serializable {

    private String score;
    private int timeResult;



    private int quizTime;
    private String name;



    public Score() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getQuizTime() {
        return quizTime;
    }

    public void setQuizTime(int quizTime) {
        this.quizTime = quizTime;
    }

    public void setTimeResult(int timeResult) {
        this.timeResult = timeResult;
    }

    public int getTimeResult() {
        return timeResult;
    }

    @Override
    public String toString() {
        return "Score{" +
                "score=" + score +
                ", timeResult=" + timeResult +
                '}';
    }
}
