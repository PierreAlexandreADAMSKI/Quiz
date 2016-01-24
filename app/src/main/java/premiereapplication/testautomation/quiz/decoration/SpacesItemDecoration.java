package premiereapplication.testautomation.quiz.decoration;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by mb-p_pilou on 07/01/2016.
 */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int spaceHorizontal;
    private int spaceVertical;

    public SpacesItemDecoration(int space) {
        this.spaceHorizontal = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = spaceHorizontal;
        outRect.right = spaceHorizontal;
        outRect.top = spaceHorizontal;

        // Add top margin only for the first item to avoid double spaceHorizontal between items
        if(parent.getChildAdapterPosition(view) == 0) {
            outRect.left = spaceHorizontal;
        }

    }
}