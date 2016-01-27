package premiereapplication.testautomation.quiz.helpers;

import java.util.List;

import premiereapplication.testautomation.quiz.objects.Category;

/**
 * Created by mb-p_pilou on 21/01/2016.
 */
public class CategoryHelper {


    public Category CINEMA=Category.CINEMA;
    public Category CULTURE_GENERALE=Category.CULTURE_GENERALE;
    public Category SPORT=Category.SPORT;
    public Category MUSIQUE=Category.MUSIQUE;
    public Category LITERATURE=Category.LITTERATURE;
    public Category Divers=Category.DIVERS;


    public CategoryHelper(Category...categories){

        this.CINEMA=categories[0];
        this.CULTURE_GENERALE=categories[1];
        this.SPORT=categories[2];
        this.MUSIQUE=categories[3];
        this.LITERATURE=categories[4];
        this.Divers=categories[5];
    }


}
