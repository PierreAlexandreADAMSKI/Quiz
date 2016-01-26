package premiereapplication.testautomation.quiz.adapters;

import android.annotation.SuppressLint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import premiereapplication.testautomation.quiz.R;
import premiereapplication.testautomation.quiz.application.QuizApplication;
import premiereapplication.testautomation.quiz.helpers.CategoryHelper;
import premiereapplication.testautomation.quiz.helpers.QuizHelper;
import premiereapplication.testautomation.quiz.interfaces.QuizHomeActivityListener;

/**
 * Created by mb-p_pilou on 24/01/2016.
 */
public class ListCategoriesAdapter extends RecyclerView.Adapter<ListCategoriesAdapter.ViewHolder> {

    public final List<CategoryHelper> listOfCategories;
    private RecyclerView quizRecyclerView;
    private LayoutInflater mLayoutInflater;
    private ViewHolder verticalHolder;



    public ListCategoriesAdapter(List<CategoryHelper> listOfCategories, List<QuizHelper> quizHelperList, QuizHomeActivityListener listener) {
        this.listOfCategories = listOfCategories;
        this.quizHelperList = quizHelperList;
        this.listener = listener;
        mLayoutInflater = LayoutInflater.from(QuizApplication.getContext());

    }

    @SuppressLint("InflateParams")
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = parent.getChildAt(getItemCount());
        if(null==convertView){
            convertView = mLayoutInflater.inflate(R.layout.fragment_list_categories,null); //adapter layout
            verticalHolder = new ViewHolder(convertView);
            verticalHolder.setListOfQuiz(this.quizHelperList);
            verticalHolder.setmListener(this.listener);
            convertView.setTag(verticalHolder);
        }else {
            verticalHolder = (ViewHolder) convertView.getTag();
        }
        return verticalHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CategoryHelper categoryHelper = getItem(position);
        holder.setCategory(categoryHelper);
        //Picasso.with(QuizApplication.getContext()).load(/*Imge uri*/).into(holder.imageQuiz);
    }

    public CategoryHelper getItem(int position) {
        return null!= listOfCategories ? listOfCategories.get(position):null ;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return null!= listOfCategories ? listOfCategories.size():0 ;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private CategoryHelper category;
        private TextView categoryName;
        private RecyclerView horizontalRecyclerView;
        private List<QuizHelper> listOfQuiz;
        private QuizHomeActivityListener mListener;

        public void setListOfQuiz(List<QuizHelper> listOfQuiz) {
            this.listOfQuiz = listOfQuiz;
        }

        public void setmListener(QuizHomeActivityListener mListener) {
            this.mListener = mListener;
        }

        public ViewHolder(View view){
            super(view);
            view = View.inflate(QuizApplication.getContext(), R.layout.fragment_list_of_quizs, null);
            this.horizontalRecyclerView = (RecyclerView) view.findViewById(R.id.quizListView);// change id.quizsListView to <RecyclerView>
            final LinearLayoutManager layoutManager = new LinearLayoutManager(QuizApplication.getContext(),LinearLayoutManager.HORIZONTAL,false); //, LinearLayoutManager.HORIZONTAL, false);
            this.horizontalRecyclerView.setLayoutManager(layoutManager);
            this.horizontalRecyclerView.setAdapter(new ListQuizAdapter(listOfQuiz, mListener));

            categoryName = (TextView) view.findViewById(R.id.categoryTitle);
        }

        public void setCategory(CategoryHelper category) {
            this.category = category;
            this.categoryName.setText(category.getTitle());

            /* TODO parse imageUrl
            if (quiz.getImageUrl() != null){
                Picasso.with(QuizApplication.getContext()).load(quiz.getImageUrl()).into(this.imageQuiz);
            }
            */
        }
    }
}

