package premiereapplication.testautomation.quiz.objects;

import java.io.Serializable;
import java.util.List;


public class ObjectQuiz implements Serializable {

public String nameOfQuiz;
public Integer durationOfQuiz;
public List<QuestionPropositionsAnswers> listQuestionPropositionsAnswers;

    public ObjectQuiz(String nameOfQuiz, int durationOfQuiz, List<QuestionPropositionsAnswers> listQuestionPropositionsAnsewers){

    this.nameOfQuiz = nameOfQuiz;
    this.durationOfQuiz = durationOfQuiz;
    this.listQuestionPropositionsAnswers = listQuestionPropositionsAnsewers;
    }


    /*@Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nameOfQuiz);
        dest.writeInt(this.durationOfQuiz);
        dest.writeList(this.listQuestionPropositionsAnswers);
    }

    protected ObjectQuiz(Parcel in) {
        this.nameOfQuiz = in.readString();
        this.durationOfQuiz = in.readInt();
        this.listQuestionPropositionsAnswers = new ArrayList<QuestionPropositionsAnswers>();
        in.readList(this.listQuestionPropositionsAnswers, List.class.getClassLoader());
    }

    public static final Parcelable.Creator<ObjectQuiz> CREATOR = new Parcelable.Creator<ObjectQuiz>() {
        public ObjectQuiz createFromParcel(Parcel source) {
            return new ObjectQuiz(source);
        }

        public ObjectQuiz[] newArray(int size) {
            return new ObjectQuiz[size];
        }
    };*/
}
