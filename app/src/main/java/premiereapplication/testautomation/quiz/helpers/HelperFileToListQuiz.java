
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

public class HelperFileToListQuiz {


    static public String readFile(Context context) {

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


    static public List<QuizHelper> getListOfQuizFromFile(Context context) {

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


    static public QuizHelper quiz(Context context, int position) {
        return getListOfQuizFromFile(context).get(position);
    }


    static public CategoryHelper getCategories(){

        List<QuizHelper> listOfAllQuizs=getListOfQuizFromFile(QuizApplication.getContext());
        List<QuizHelper> listOfCinemaQuiz=new ArrayList<>();
        List<QuizHelper> listOfCultureGeneraleQuiz=new ArrayList<>();
        List<QuizHelper> listOfSportQuiz=new ArrayList<>();
        List<QuizHelper> listOfMusiqueQuiz=new ArrayList<>();
        List<QuizHelper> listOfLiteratureQuiz=new ArrayList<>();
        List<QuizHelper> listOfDiversQuiz=new ArrayList<>();


        for(int i=0;i<listOfAllQuizs.size();i++){
        if(listOfAllQuizs.get(i).getCategory().equals("Cinema")){listOfCinemaQuiz.add(listOfAllQuizs.get(i));}
        else if (listOfAllQuizs.get(i).getCategory().equals("Culture Generale")){listOfCultureGeneraleQuiz.add(listOfAllQuizs.get(i));}
        else if (listOfAllQuizs.get(i).getCategory().equals("Sport")){listOfSportQuiz.add(listOfAllQuizs.get(i));}
        else if (listOfAllQuizs.get(i).getCategory().equals("Musique")){listOfMusiqueQuiz.add(listOfAllQuizs.get(i));}
        else if (listOfAllQuizs.get(i).getCategory().equals("Literature")){listOfLiteratureQuiz.add(listOfAllQuizs.get(i));}
        else if (listOfAllQuizs.get(i).getCategory().equals("Divers")){listOfDiversQuiz.add(listOfAllQuizs.get(i));}
        }
        CategoryHelper categoryHelper= new CategoryHelper(listOfCinemaQuiz,listOfCultureGeneraleQuiz,listOfSportQuiz,
                listOfMusiqueQuiz,listOfLiteratureQuiz,listOfDiversQuiz);

        return categoryHelper;
    }





    static public void display(List <QuizHelper> listOfQuizs) {

        for (int i = 0; i < listOfQuizs.size(); i++) {

            System.out.println("\n\n\nQuiz " + (i + 1));

            String quizCategory = listOfQuizs.get(i).getCategory();
            String quizName = listOfQuizs.get(i).getName();
            int quizDuration = listOfQuizs.get(i).getSec();
            List<Question> listQuestions = listOfQuizs.get(i).getQuestions();

            System.out.println("Categorie du Quiz :" + quizCategory);
            System.out.println("Nom du Quiz :" + quizName);
            System.out.println("Duree du Quiz :" + quizDuration + "\n");


            for (int j = 0; j < listQuestions.size(); j++) {
                String enonceQuestion = listQuestions.get(j).getQuestion();
                List<Answer> listAnsewers = listQuestions.get(j).getAnswers();

                System.out.println("question " + (j + 1) + " : " + enonceQuestion);
                System.out.println("Propositions :");
                for (int k = 0; k < listAnsewers.size(); k++) {
                    System.out.println(listAnsewers.get(k).getText());
                }
                System.out.println("Reponses :");
                System.out.println();
                for (int k = 0; k < listAnsewers.size(); k++) {
                    System.out.println(listAnsewers.get(k).isGoodAnswer());
                }
            }
        }

    }
}

