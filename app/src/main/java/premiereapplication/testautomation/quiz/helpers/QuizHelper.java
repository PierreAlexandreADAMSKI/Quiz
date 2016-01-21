package premiereapplication.testautomation.quiz.helpers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import premiereapplication.testautomation.quiz.objects.Question;

public class QuizHelper implements Serializable{

    private String name;
    private Integer sec;
    private String imageUrl;


    private List<Question> questions;


    public QuizHelper(String name, Integer sec) {
        this.name = name;
        this.sec = sec;
        this.questions = new ArrayList<>();
    }

    public Integer getSec() {
        return sec;
    }

    public void setSec(Integer sec) {
        this.sec = sec;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Question> getQuestions() {
        return this.questions;
    }
}
