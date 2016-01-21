package premiereapplication.testautomation.quiz.adapters;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import premiereapplication.testautomation.quiz.R;
import premiereapplication.testautomation.quiz.aplication.QuizApplication;
import premiereapplication.testautomation.quiz.helpers.QuizHelper;
import premiereapplication.testautomation.quiz.interfaces.QuizHomeActivityListener;


public class ListQuizAdapter extends RecyclerView.Adapter<ListQuizAdapter.ViewHolder> {

    public final List<QuizHelper> listOfQuiz;
    private LayoutInflater mLayoutInflater;
    private ViewHolder verticalHolder;
    private QuizHomeActivityListener clickListener;



    public ListQuizAdapter(List<QuizHelper> ListOfQuiz, QuizHomeActivityListener clickListener) {
        this.listOfQuiz = ListOfQuiz;
        this.clickListener = clickListener;
        mLayoutInflater = LayoutInflater.from(QuizApplication.getContext());

    }

    @SuppressLint("InflateParams")
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = parent.getChildAt(getItemCount());
        if(null==convertView){
            convertView = mLayoutInflater.inflate(R.layout.items_of_quizs_listview,null); //adapter layout
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
        QuizHelper quiz = getItem(position);
        holder.setQuiz(quiz);
        //Picasso.with(QuizApplication.getContext()).load(/*Imge uri*/).into(holder.imageQuiz);
    }

    public QuizHelper getItem(int position) {
        return null!= listOfQuiz ? listOfQuiz.get(position):null ;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return null!= listOfQuiz ? listOfQuiz.size():0 ;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private QuizHomeActivityListener listener;
        private QuizHelper quiz;
        private TextView nameQuiz;
        private TextView timerQuiz;
        private ImageView imageQuiz;


        public ViewHolder(View view){
            super(view);
            nameQuiz = (TextView) view.findViewById(R.id.nomQuizLaunchedTextView);
            timerQuiz = (TextView) view.findViewById(R.id.dureeQuizLaunchedTextView);
            imageQuiz = (ImageView) view.findViewById(R.id.quizImageView);
            view.setOnClickListener(this);
        }

        public void setListener(QuizHomeActivityListener listener) {
            this.listener = listener;
        }

        public void setQuiz(QuizHelper quiz) {
            this.quiz = quiz;
            this.nameQuiz.setText(quiz.getName());
            this.timerQuiz.setText(String.valueOf(quiz.getSec()));

            /* TODO parse imageUrl
            if (quiz.getImageUrl() != null){
                Picasso.with(QuizApplication.getContext()).load(quiz.getImageUrl()).into(this.imageQuiz);
            }
            */
        }

        @Override
        public void onClick(View v) {
            if (quiz != null){
                this.listener.onQuizSelected(this.quiz);
            }
            //TODO else exception + log
        }
    }

}
