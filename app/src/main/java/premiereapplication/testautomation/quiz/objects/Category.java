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

    private List<QuizHelper> list=new ArrayList<QuizHelper>();

    public static String parse(Category category){

        if (category == CINEMA){
            return "Cinema";
        }
        if (category == GENERAL_KNOWLEDGE){
            return "General Knowledge";
        }
        if (category == SPORT){
            return "Sport";
        }
        if (category == MUSIC){
            return "Music";
        }
        if (category == LITERATURE){
            return "Literature";
        }
        if (category == VARIOUS){
            return "Various";
        }
        return null;
    }

    public void setList (List<QuizHelper> list){
        this.list=list;
    }

    public  List<QuizHelper> getList(){return this.list;}

}
