package premiereapplication.testautomation.quiz.objects;

import java.io.Serializable;

/**
 * Created by mb-p_pilou on 21/01/2016.
 */
public enum Category implements Serializable {
    CULTURE_GENERALE,
    CINEMA,
    MUSIQUE,
    LITTERATURE,
    ACTUALITE;

    public String parse(Category category){
        if (category == CULTURE_GENERALE){
            return "Culture Générale";
        }
        if (category == CINEMA){
            return "Cinéma";
        }
        if (category == MUSIQUE){
            return "Musique";
        }
        if (category == LITTERATURE){
            return "Littérature";
        }
        if (category == ACTUALITE){
            return "Actualité";
        }
        return null;
    }
}
