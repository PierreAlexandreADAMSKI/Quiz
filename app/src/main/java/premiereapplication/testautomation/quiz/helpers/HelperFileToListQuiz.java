
package premiereapplication.testautomation.quiz.helpers;


import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import premiereapplication.testautomation.quiz.application.QuizApplication;
import premiereapplication.testautomation.quiz.objects.Answer;
import premiereapplication.testautomation.quiz.objects.Category;
import premiereapplication.testautomation.quiz.objects.Question;

/**
 *  created by Achraf
 */

public class HelperFileToListQuiz {
    public static String readFile(Context context) {

        String contenuFichierEntier = "";
        InputStream input = null;
        try {

            input = context.getResources().getAssets().open("quizs.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String ligne = "";
            BufferedReader bfr = new BufferedReader(new InputStreamReader(input));

            while ((ligne = bfr.readLine()) != null) {

                contenuFichierEntier = contenuFichierEntier + ligne;
            }


            bfr.close();
        } catch (Exception e) {
            contenuFichierEntier = e.getMessage();
            System.out.println(e.getMessage());
        }
        return contenuFichierEntier;
    }


    public static List<QuizHelper> getListOfQuizFromFile(Context context) {

        String fileContent = readFile(context);

        List<QuizHelper> listOfQuiz = new ArrayList<>();
        String arrayOfQuizs[] = fileContent.split("Quiz");
        for (int i = 0; i < arrayOfQuizs.length; i++) {
            String quiCategory=arrayOfQuizs[i].split("//")[0];
            String quizName = arrayOfQuizs[i].split("//")[1];
            int quizDuration = Integer.parseInt(arrayOfQuizs[i].split("//")[2]);
            List<Question> listQuestion = new ArrayList<Question>();
            String arrayQuestion[] = arrayOfQuizs[i].split("//")[3].split(">");
            for (int j = 0; j < arrayQuestion.length; j++) {
                String enonceQuestion = arrayQuestion[j].split("<")[0];


                List<Answer> listAnswers = new ArrayList<>();
                String PA = arrayQuestion[j].split("<")[1];
                String arrayP[] = PA.split("/")[0].split(",");
                String arrayA[] = PA.split("/")[1].split(",");
                for (int n = 0; n <arrayP.length; n++) {
                    if (arrayA[n].equals("true")) {
                        Answer answer = new Answer(arrayP[n],true);
                        listAnswers.add(answer);
                    } else {
                        Answer answer = new Answer(arrayP[n],false);
                        listAnswers.add(answer);
                    }

                }

                Question question = new Question(enonceQuestion, listAnswers);
                listQuestion.add(question);


            }

            QuizHelper oq = new QuizHelper(quiCategory,quizName, quizDuration, listQuestion);
            listOfQuiz.add(oq);
        }

        return listOfQuiz;

    }


    public static CategoryHelper getCategories(){

        Category CINEMA = Category.CINEMA;
        Category GENERAL_KNOWLEDGE = Category.GENERAL_KNOWLEDGE;
        Category SPORT = Category.SPORT;
        Category MUSIC = Category.MUSIC;
        Category LITERATURE = Category.LITERATURE;
        Category VARIOUS = Category.VARIOUS;

        List<QuizHelper> listOfAllQuiz = getListOfQuizFromFile(QuizApplication.getContext());
        List<QuizHelper> listOfCinemaQuiz = new ArrayList<>();
        List<QuizHelper> listOfGeneralKnowledgeQuiz = new ArrayList<>();
        List<QuizHelper> listOfSportQuiz = new ArrayList<>();
        List<QuizHelper> listOfMusicQuiz = new ArrayList<>();
        List<QuizHelper> listOfLiteratureQuiz = new ArrayList<>();
        List<QuizHelper> listOfVariousQuiz = new ArrayList<>();

        for(int i=0;i<listOfAllQuiz.size();i++){
            if(listOfAllQuiz.get(i).getCategory().equals(Category.parse(CINEMA)))
            {listOfCinemaQuiz.add(listOfAllQuiz.get(i));}

            else if (listOfAllQuiz.get(i).getCategory().equals(Category.parse(GENERAL_KNOWLEDGE)))
            {listOfGeneralKnowledgeQuiz.add(listOfAllQuiz.get(i));}

            else if (listOfAllQuiz.get(i).getCategory().equals(Category.parse(SPORT)))
            {listOfSportQuiz.add(listOfAllQuiz.get(i));}

            else if (listOfAllQuiz.get(i).getCategory().equals(Category.parse(MUSIC)))
            {listOfMusicQuiz.add(listOfAllQuiz.get(i));}

            else if (listOfAllQuiz.get(i).getCategory().equals(Category.parse(LITERATURE)))
            {listOfLiteratureQuiz.add(listOfAllQuiz.get(i));}

            else if (listOfAllQuiz.get(i).getCategory().equals(Category.parse(VARIOUS)))
            {listOfVariousQuiz.add(listOfAllQuiz.get(i));}
        }

        CINEMA.setList(listOfCinemaQuiz);
        GENERAL_KNOWLEDGE.setList(listOfGeneralKnowledgeQuiz);
        SPORT.setList(listOfSportQuiz);
        MUSIC.setList(listOfMusicQuiz);
        LITERATURE.setList(listOfLiteratureQuiz);
        VARIOUS.setList(listOfVariousQuiz);

        CategoryHelper categoryHelper= new CategoryHelper(CINEMA,GENERAL_KNOWLEDGE,SPORT,MUSIC,LITERATURE,VARIOUS);

        return categoryHelper;
    }
}

