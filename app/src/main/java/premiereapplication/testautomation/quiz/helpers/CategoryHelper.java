package premiereapplication.testautomation.quiz.helpers;

import java.util.ArrayList;
import java.util.List;

import premiereapplication.testautomation.quiz.objects.Category;

/**
 * Created by mb-p_pilou on 21/01/2016.
 */
public class CategoryHelper {

    public List<QuizHelper> listOfCinemaQuiz=new ArrayList<QuizHelper>();
    public List<QuizHelper> listOfCultureGeneraleQuiz=new ArrayList<QuizHelper>();
    public List<QuizHelper> listOfSportQuiz=new ArrayList<QuizHelper>();
    public List<QuizHelper> listOfMusiqueQuiz=new ArrayList<QuizHelper>();
    public List<QuizHelper> listOfLiteratureQuiz=new ArrayList<QuizHelper>();
    public List<QuizHelper> listOfDiversQuiz=new ArrayList<QuizHelper>();

  public CategoryHelper(List<QuizHelper> listOfCinemaQuiz,List<QuizHelper> listOfCultureGeneraleQuiz,List<QuizHelper> listOfSportQuiz,
                        List<QuizHelper> listOfMusiqueQuiz,List<QuizHelper> listOfLiteratureQuiz,List<QuizHelper> listOfDiversQuiz){

    this.listOfCinemaQuiz=listOfCinemaQuiz;
    this.listOfCultureGeneraleQuiz=listOfCultureGeneraleQuiz;
    this.listOfSportQuiz=listOfSportQuiz;
    this.listOfMusiqueQuiz=listOfMusiqueQuiz;
    this.listOfLiteratureQuiz=listOfLiteratureQuiz;
    this.listOfDiversQuiz=listOfDiversQuiz;
    }



}
