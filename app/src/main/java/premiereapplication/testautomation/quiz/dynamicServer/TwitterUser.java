package premiereapplication.testautomation.quiz.dynamicServer;

/**
 * Created by User on 18/01/2016.
 */
import com.google.gson.annotations.SerializedName;


public class TwitterUser {

    @SerializedName("screen_name")
    public String screenName;

    @SerializedName("name")
    public String name;

    @SerializedName("profile_image_url")
    public String profileImageUrl;

}