
package premiereapplication.testautomation.quiz.helpers;


import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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



        String arryofQuizs[] = fileContent.split("Quiz");

        for (int i = 0; i < arryofQuizs.length; i++) {
            String quizName = arryofQuizs[i].split("//")[0];
            int quizDuration = Integer.parseInt(arryofQuizs[i].split("//")[1]);
            List<Question> listQuestion = new ArrayList<Question>();

            String arrayQuestion[] = arryofQuizs[i].split("//")[2].split(">");
            for (int j = 0; j < arrayQuestion.length; j++) {
                String enonceQuestion = arrayQuestion[j].split("<")[0];
                //List<String> listePropositions = new ArrayList<>();
                //List<String> listeAnsewers = new ArrayList<>();
                

                String propositionsAnsewers = arrayQuestionPropositionsAnsewers[j].split("<")[1];
                String arrayPropositions[] = propositionsAnsewers.split("/")[0].split(",");
                String arrayAnsewers[] = propositionsAnsewers.split("/")[1].split(",");
                for (int n = 0; n < arrayPropositions.length; n++) {
                    listePropositions.add(arrayPropositions[n]);
                }
                for (int n = 0; n < arrayAnsewers.length; n++) {
                    listeAnsewers.add(arrayAnsewers[n]);
                }
                QuestionPropositionsAnswers qpr = new QuestionPropositionsAnswers(enonceQuestion, listePropositions, listeAnsewers);
                listeQuestionPropositionsAnsewers.add(qpr);


            }

            QuizHelper oq = new QuizHelper(quizName, quizDuration, listeQuestionPropositionsAnsewers);
            listOfQuiz.add(oq);
        }

    return listOfQuiz;
    }



    static public ObjectQuiz getQuiz(Context context,int position) {

        return getListOfQuizFromFile(context).get(position);

    }





/*static public void display(List <ObjectQuiz> listOfQuizs) {

        for (int i = 0; i < listOfQuizs.size(); i++) {

            System.out.println("\n\n\nQuiz " + (i + 1));

            String nomQuiz = listOfQuizs.get(i).nameOfQuiz;
            int dureeQuiz = listOfQuizs.get(i).durationOfQuiz;
            List<QuestionPropositionsAnswers> listQuestionPropositionsAnswers = listOfQuizs.get(i).listQuestionPropositionsAnswers;

            System.out.println("Nom du Quiz :" + nomQuiz);
            System.out.println("Duree du Quiz :" + dureeQuiz + "\n");


            for (int j = 0; j < listQuestionPropositionsAnswers.size(); j++) {
                String enonceQuestion = listQuestionPropositionsAnswers.get(j).question;
                List<String> listPropositions = listQuestionPropositionsAnswers.get(j).propositions;
                List<String> listReponses = listQuestionPropositionsAnswers.get(j).answers;

                System.out.println("question " + (j + 1) + " : " + enonceQuestion);
                System.out.println("Propositions :");
                for (int k = 0; k < listPropositions.size(); k++) {
                    System.out.println(listPropositions.get(k));
                }
                System.out.println("Reponses :");
                System.out.println();
                for (int k = 0; k < listReponses.size(); k++) {
                    System.out.println(listReponses.get(k));
                }
            }
        }

    }

    static public void display(ObjectQuiz Quiz) {
            String nomQuiz = Quiz.nameOfQuiz;
            int dureeQuiz = Quiz.durationOfQuiz;
            List<QuestionPropositionsAnswers> listQuestionPropositionsAnswers = Quiz.listQuestionPropositionsAnswers;

            System.out.println("Nom du Quiz :" + nomQuiz);
            System.out.println("Duree du Quiz :" + dureeQuiz + "\n");


            for (int j = 0; j < listQuestionPropositionsAnswers.size(); j++) {
                String enonceQuestion = listQuestionPropositionsAnswers.get(j).question;
                List<String> listPropositions = listQuestionPropositionsAnswers.get(j).propositions; //changer nom en list propo
                List<String> listReponses = listQuestionPropositionsAnswers.get(j).answers;//changer en liste rep

                System.out.println("question " + (j + 1) + " : " + enonceQuestion);
                System.out.println("Propositions :");
                for (int k = 0; k < listPropositions.size(); k++) {
                    System.out.println(listPropositions.get(k));
                }
                System.out.println("Reponses :");
                System.out.println();
                for (int k = 0; k < listReponses.size(); k++) {
                    System.out.println(listReponses.get(k));
                }
            }
        }*//*



}





















































*/
