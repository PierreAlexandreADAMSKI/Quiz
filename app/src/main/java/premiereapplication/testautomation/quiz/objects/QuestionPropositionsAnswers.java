package premiereapplication.testautomation.quiz.objects;


import java.io.Serializable;
import java.util.List;

public class QuestionPropositionsAnswers implements Serializable{

    public String question;
    public List<String> propositions;
    public List<String> answers;


    public QuestionPropositionsAnswers(String question, List<String> propositions, List<String> ansewers){
        this.question=question;
        this.propositions=propositions;
        this.answers = ansewers;
    }

}
