package premiereapplication.testautomation.quiz.utils;

import android.graphics.drawable.Drawable;

import premiereapplication.testautomation.quiz.R;
import premiereapplication.testautomation.quiz.helpers.QuizHelper;
import premiereapplication.testautomation.quiz.objects.Category;

/**
 * Created by User on 27/01/2016.
 */
public  class DrawableManager {


    static public int getDrawable(QuizHelper quizHelper) {


        if (quizHelper.getName().equals("Batman")) {
            return R.drawable.batman;
        }
        else if (quizHelper.getName().equals("Avatar")) {
            return R.drawable.avatar;
        }

         else if (quizHelper.getName().equals("Kill-Bill")) {
            return R.drawable.killbill;
        }

        else if (quizHelper.getName().equals("Rock")) {
            return R.drawable.rock;
        }

        else if (quizHelper.getName().equals("Jazz")) {
            return R.drawable.jazz;
        }

        else if (quizHelper.getName().equals("Classique")) {
            return R.drawable.classic;
        }

        else if (quizHelper.getName().equals("Football")) {
            return R.drawable.football;
        }

        else if (quizHelper.getName().equals("Basketball")) {
            return R.drawable.basketball;
        }

        else if (quizHelper.getName().equals("Athletisme")) {
            return R.drawable.athletisme;
        }

        else if (quizHelper.getName().equals("Poésie")) {
            return R.drawable.poesie;
        }

        else if (quizHelper.getName().equals("Essais")) {
            return R.drawable.essaie;
        }

        else if (quizHelper.getName().equals("Polars")) {
            return R.drawable.polar;
        }


        else{

            if (quizHelper.getCategory().equals("Cinéma")) {return R.drawable.cinema;}

            else if (quizHelper.getCategory().equals("Culture Générale")) {
                return R.drawable.culturegenerale;
            }
            else if (quizHelper.getCategory().equals("Sports")) {
                return R.drawable.sport;
            }

            else if (quizHelper.getCategory().equals("Musique")) {
                return R.drawable.musique;
            }

            else if (quizHelper.getCategory().equals("Littérature")) {
                return R.drawable.literature;
            }

            else if (quizHelper.getCategory().equals("Divers")) {
                return R.drawable.divers;
            }

        }


        return 0;



    }

}