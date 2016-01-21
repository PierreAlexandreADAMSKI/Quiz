package premiereapplication.testautomation.quiz.interfaces;

import premiereapplication.testautomation.quiz.helpers.QuizHelper;

/**
 * Created by User on 17/01/2016.
 */
public interface QuizHomeActivityListener {
    void moveToListOfStaticQuizFragment();
    void moveToListOfDynamicQuizFragment();
    void moveToListOfResultsFragment();
    void onQuizSelected(QuizHelper quiz);
}
