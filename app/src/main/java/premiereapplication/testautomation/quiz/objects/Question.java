package premiereapplication.testautomation.quiz.objects;


import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
/**
 * Created by mb-p_pilou on 21/01/2016.
 */

public class Question implements Serializable{

    private String question;

    private List<Answer> answers;

    public Question(String question, Answer answer1, Answer answer2, Answer answer3) {
        super();
        this.question = question;
        this.answers = Arrays.asList(answer1, answer2, answer3);
    }

    public Question() {
        this("Question", new Answer("answer 1", true), new Answer("answer 2", false), new Answer("answer 3", false));
    }

    public String getQuestion() {
        return question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

}
