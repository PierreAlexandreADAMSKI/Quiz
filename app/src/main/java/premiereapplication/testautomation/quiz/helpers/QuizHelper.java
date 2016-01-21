package premiereapplication.testautomation.quiz.helpers;

import java.io.Serializable;
import java.util.List;

import premiereapplication.testautomation.quiz.objects.Category;
import premiereapplication.testautomation.quiz.objects.Question;

public class QuizHelper implements Serializable{

    private String name;
    private Integer sec;
    private Category category;
    private String imageUrl;


    private List<Question> questions;


    public QuizHelper(Category category, String name, Integer millis) {
        this.category = category;
        this.name = name;
        this.sec = millis;
    }

    public Integer getSec() {
        return sec;
    }

    public void setSec(Integer sec) {
        this.sec = sec;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void addAllQuestions(List<Question> questions) {
        questions.addAll(questions);
    }


}
