package premiereapplication.testautomation.quiz.helpers;

import java.util.List;

import premiereapplication.testautomation.quiz.objects.Category;

/**
 * Created by mb-p_pilou on 21/01/2016.
 */
public class CategoryHelper {


    public Category CINEMA=Category.CINEMA;
    public Category GENERAL_KNOWLEDGE =Category.GENERAL_KNOWLEDGE;
    public Category SPORT=Category.SPORT;
    public Category MUSIC=Category.MUSIC;
    public Category LITERATURE=Category.LITERATURE;
    public Category VARIOUS=Category.VARIOUS;


    public CategoryHelper(Category...categories){

        this.CINEMA=categories[0];
        this.GENERAL_KNOWLEDGE=categories[1];
        this.SPORT=categories[2];
        this.MUSIC=categories[3];
        this.LITERATURE=categories[4];
        this.VARIOUS=categories[5];
    }


}
