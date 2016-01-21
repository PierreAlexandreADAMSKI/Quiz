package premiereapplication.testautomation.quiz.objects;


import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
/**
 * Created by mb-p_pilou on 21/01/2016.
 */

public class Question implements Serializable {

    private String question;
    private List<Answer> answers;

    public Question(String question, Answer... answers) {
        super();
        this.question = question;
        this.answers = Arrays.asList(answers);
    }

    public Question(String question,List<Answer> answers) { // I kept the three constructors to avoid conflict
        super();
        this.question = question;
        this.answers =answers;
    }

    public Question() {
        this("Question", new Answer("answer 1", true), new Answer("answer 2", false), new Answer("answer 3", false));
    }

    public String getQuestion() {
        return question;
    }


    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
