package premiereapplication.testautomation.quiz.helpers;

import java.util.List;

import premiereapplication.testautomation.quiz.objects.Category;

/**
 * Created by mb-p_pilou on 21/01/2016.
 */
public class CategoryHelper {
    private Category title;
    private List<QuizHelper> quizOfCathegory;

    public CategoryHelper(List<QuizHelper> quizOfCathegory, Category title) {
        this.quizOfCathegory = quizOfCathegory;
        this.title = title;
    }

    public List<QuizHelper> getAllQuizz() {
        return quizOfCathegory;
    }

    public void addAllQuiz(List<QuizHelper> quizOfCathegory) {
        this.quizOfCathegory.addAll(quizOfCathegory);
    }

    public QuizHelper get(int index) {
        return quizOfCathegory.get(index);
    }

    public void add(QuizHelper quiz) {
        this.quizOfCathegory.add(quiz);
    }

    public String getTitle() {
        return Category.parse(title);
    }

    public void setTitle(Category title) {
        this.title = title;
    }
}
