package premiereapplication.testautomation.quiz.interfaces;

import java.util.List;

import premiereapplication.testautomation.quiz.helpers.CategoryHelper;
import premiereapplication.testautomation.quiz.helpers.CategoryHelper;
import premiereapplication.testautomation.quiz.helpers.QuizHelper;

public interface QuizRetrievedListener {

	public void onQuizRetrieved(List<CategoryHelper> categoryHelperList);
	public void onQuizRetrieved(CategoryHelper categoryHelper);

}
