package premiereapplication.testautomation.quiz.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import premiereapplication.testautomation.quiz.R;
import premiereapplication.testautomation.quiz.application.QuizApplication;
import premiereapplication.testautomation.quiz.interfaces.QuizActivityListener;
import premiereapplication.testautomation.quiz.objects.Answer;

/**
 * Created by User on 13/01/2016.
 */


public class AnswersAdapter extends RecyclerView.Adapter<AnswersAdapter.ViewHolder> {

    private List<Answer> answers;

    private LayoutInflater mLayoutInflater;

    private ViewHolder answerViewHolder;

    private QuizActivityListener activityListener;

    public AnswersAdapter(List<Answer> answers, QuizActivityListener activityListener) {
        this.answers = answers;
        this.activityListener = activityListener;
        mLayoutInflater = LayoutInflater.from(QuizApplication.getContext());
    }

    public Answer getItem(int position) {
        return null!= answers ? answers.get(position):null ;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = parent.getChildAt(getItemCount());
        if(null == convertView){
            convertView=mLayoutInflater.inflate(R.layout.items_of_propositions,null);
            answerViewHolder = new ViewHolder(convertView);
            answerViewHolder.setListener(activityListener);
            convertView.setTag(answerViewHolder);
        }
        else{
            answerViewHolder = (ViewHolder) convertView.getTag();
        }
        return answerViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Answer answer = getItem(position);
        holder.setAnswer(answer);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return null!= answers ? answers.size():0 ;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private Answer answer;
        private TextView answerText;

        private QuizActivityListener listener;

        public ViewHolder(View view){
            super(view);
            answerText = (TextView) view.findViewById(R.id.propositionButton);
            view.setOnClickListener(this);
        }

        public void setAnswer(Answer answer) {
            this.answer = answer;
            this.answerText.setText(answer.getText());
        }

        public void setListener(QuizActivityListener listener) {
            this.listener = listener;
        }

        @Override
        public void onClick(View v) {
            if (this.answer.isGoodAnswer()){
                this.listener.scoreIncrementation();
                v.setBackgroundColor(Color.GREEN);

            }
            else{
                v.setBackgroundColor(Color.RED);
            }

            this.listener.nextQuestion();
        }
    }
}
