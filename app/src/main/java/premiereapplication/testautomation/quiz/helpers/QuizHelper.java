package premiereapplication.testautomation.quiz.helpers;

import java.io.Serializable;
import java.util.List;

import premiereapplication.testautomation.quiz.objects.Question;

public class QuizHelper implements Serializable{

    private String category;
    private String name;
    private Integer sec;
    private String imageUrl;
    private List<Question> questions;


    public QuizHelper(String name, Integer sec) {
        this.name = name;
        this.sec = sec;
    }

    public QuizHelper(String category,String name, Integer sec,List <Question> questions) { // I kept the two constuctors to avoid conflict
        this.category=category;
        this.name = name;
        this.sec = sec;
        this.questions = questions;
    }

    public String getCategory() {return category;}

    public void setCategory(String category) {this.category = category;}



    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public Integer getSec() {
        return sec;
    }

    public void setSec(Integer sec) {
        this.sec = sec;
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

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void addAllQuestions(List<Question> questions) {
        questions.addAll(questions);
    }


}
