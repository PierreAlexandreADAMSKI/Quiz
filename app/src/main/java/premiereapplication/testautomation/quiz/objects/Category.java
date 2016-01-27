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
    CULTURE_GENERALE,
    SPORT,
    MUSIQUE,
    LITTERATURE,
    DIVERS;

    private List<QuizHelper> list=new ArrayList<QuizHelper>();

    public static String parse(Category category){

        if (category == CINEMA){
            return "Cinéma";
        }
        if (category == CULTURE_GENERALE){
            return "Culture Générale";
        }
        if (category == SPORT){
            return "Sport";
        }
        if (category == MUSIQUE){
            return "Musique";
        }
        if (category == LITTERATURE){
            return "Littérature";
        }
        if (category == DIVERS){
            return "Divers";
        }
        return null;
    }

    public void setList (List<QuizHelper> list){
        this.list=list;
    }

    public  List<QuizHelper> getList(){return this.list;}

}
