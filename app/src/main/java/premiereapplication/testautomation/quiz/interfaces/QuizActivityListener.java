package premiereapplication.testautomation.quiz.interfaces;


public interface QuizActivityListener {

    public void nextQuestion();
    public void scoreIncrementation();
    void onQuizEnd(String time,boolean isTimeOut);
    public void finishActivity();

}
