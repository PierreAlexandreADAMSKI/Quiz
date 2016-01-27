package premiereapplication.testautomation.quiz.objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import premiereapplication.testautomation.quiz.helpers.QuizHelper;

/**
 * Created by mb-p_pilou on 21/01/2016.
 */
public enum Category implements Serializable {
    CINEMA,
    GENERAL_KNOWLEDGE,
    SPORT,
    MUSIC,
    LITERATURE,
    VARIOUS;

    private List<QuizHelper> list = new ArrayList<>();

    public static String parse(Category category){

        if (category == CINEMA){
            return "Cinéma";
        }
        if (category == GENERAL_KNOWLEDGE){
            return "Culture Générale";
        }
        if (category == SPORT){
            return "Sport";
        }
        if (category == MUSIC){
            return "Musique";
        }
        if (category == LITERATURE){
            return "Littérature";
        }
        if (category == VARIOUS){
            return "Divers";
        }
        return null;
    }

    public void setList (List<QuizHelper> list){
        this.list=list;
    }

    public  List<QuizHelper> getList(){return this.list;}

}
