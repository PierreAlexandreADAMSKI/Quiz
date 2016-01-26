package premiereapplication.testautomation.quiz.adapters;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import premiereapplication.testautomation.quiz.R;
import premiereapplication.testautomation.quiz.application.QuizApplication;
import premiereapplication.testautomation.quiz.helpers.QuizHelper;
import premiereapplication.testautomation.quiz.interfaces.QuizHomeActivityListener;
import premiereapplication.testautomation.quiz.objects.Score;

/**
 * Created by isen on 25/01/2016.
 */
public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ViewHolder> {

    public final List<Score> listofScore;
    private LayoutInflater mLayoutInflater;
    private ViewHolder verticalHolder;
    private QuizHomeActivityListener clickListener;


    public ScoreAdapter(List<Score> listofScore, QuizHomeActivityListener clickListener) {
        this.listofScore = listofScore;
        this.clickListener = clickListener;
        mLayoutInflater = LayoutInflater.from(QuizApplication.getContext());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = parent.getChildAt(getItemCount());
        if(null==convertView){
            convertView = mLayoutInflater.inflate(R.layout.items_of_results,null); //adapter layout
            verticalHolder = new ViewHolder(convertView);
            verticalHolder.setListener(this.clickListener);
            convertView.setTag(verticalHolder);
        }else {
            verticalHolder = (ViewHolder) convertView.getTag();
        }
        return verticalHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Score score = getItem(position);
        holder.setScore(score);
    }

    public Score getItem(int position) {
        return null!= listofScore ? listofScore.get(position):null ;
    }

    @Override
    public int getItemCount() {
        return null!= listofScore ? listofScore.size():0 ;    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private QuizHomeActivityListener listener;
        private Score score;
        private TextView scoreName;
        private TextView scoreValue;


        public ViewHolder(View view){
            super(view);
            scoreName = (TextView) view.findViewById(R.id.scoreName);
            scoreValue = (TextView) view.findViewById(R.id.scoreValue);

            view.setOnClickListener(this);
        }

        public void setListener(QuizHomeActivityListener listener) {
            this.listener = listener;
        }

        public void setScore(Score score) {
            this.score = score;
            this.scoreName.setText(this.score.getName());
            this.scoreValue.setText(String.valueOf(score.getScore()));
            /* TODO parse imageUrl
            if (quiz.getImageUrl() != null){
                Picasso.with(QuizApplication.getContext()).load(quiz.getImageUrl()).into(this.imageQuiz);
            }
            */
        }

        @Override
        public void onClick(View v) {
            /* It will be used with separated categories
            if (score != null){
                this.listener.onResultSelected(this.score);
            }*/
            //TODO else exception + log
        }
    }
}