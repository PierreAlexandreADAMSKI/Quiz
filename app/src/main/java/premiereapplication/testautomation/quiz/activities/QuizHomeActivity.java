package premiereapplication.testautomation.quiz.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import premiereapplication.testautomation.quiz.R;
import premiereapplication.testautomation.quiz.fragments.FragmentsOfQuizHomeActivity.GlobalListOfQuizFragment;
import premiereapplication.testautomation.quiz.fragments.FragmentsOfQuizHomeActivity.ListOfQuizFragment;
import premiereapplication.testautomation.quiz.fragments.FragmentsOfQuizHomeActivity.ListOfResultsFragment;
import premiereapplication.testautomation.quiz.fragments.FragmentsOfQuizHomeActivity.PrincipalMenuFragment;
import premiereapplication.testautomation.quiz.helpers.QuizHelper;
import premiereapplication.testautomation.quiz.interfaces.QuizHomeActivityListener;
import premiereapplication.testautomation.quiz.utils.PreferenceUtils;

public class QuizHomeActivity extends AppCompatActivity implements QuizHomeActivityListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_home);

        final String login = getIntent().getExtras().getString("Login");

        // Set as ActionBar subtitle
        // getActionBar().setSubtitle(login);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.container,new PrincipalMenuFragment()).commit();
        }
    }

    @Override
    public void onBackPressed()
    {
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.quiz, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.actionLogout) {
            // Erase login and password in Preferences
            PreferenceUtils.setLogin(null);
            // Finish this activity, and go back to LoginActivity
            finish();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void moveToListOfStaticQuizFragment() {

        //ListOfQuizFragment frag= ListOfQuizFragment.getInstance(false);
        //getFragmentManager().beginTransaction().add(R.id.container, frag).commit();
         getFragmentManager().beginTransaction().add(R.id.container, new GlobalListOfQuizFragment()).commit();
    }

    @Override
    public void moveToListOfDynamicQuizFragment() {
        ListOfQuizFragment frag= ListOfQuizFragment.getInstance(true);
        getFragmentManager().beginTransaction().add(R.id.container, frag).commit();
    }


    @Override
    public void moveToListOfResultsFragment() {
        getFragmentManager().beginTransaction().replace(R.id.container, new ListOfResultsFragment()).commit();
    }


    @Override
    public void onQuizSelected(QuizHelper quiz) {
        final Intent intent = new Intent(this, QuizActivity.class);
        final Bundle extras = new Bundle();
        extras.putSerializable("QuizToLaunch", quiz);
        intent.putExtras(extras);
        startActivity(intent);
    }
}
