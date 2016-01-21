package premiereapplication.testautomation.quiz.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import premiereapplication.testautomation.quiz.R;
import premiereapplication.testautomation.quiz.aplication.QuizApplication;
import premiereapplication.testautomation.quiz.utils.PreferenceUtils;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button SignInButton;
    private EditText loginEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginEditText=(EditText) findViewById(R.id.loginEditText);

        SignInButton=(Button) findViewById(R.id.SignInButton);
        SignInButton.setOnClickListener(this);

        final String storedLogin = PreferenceUtils.getStoredLogin();

        if ((!TextUtils.isEmpty(storedLogin))){
            final Intent homeIntent = getHomeActivityIntent(storedLogin);
            startActivity(homeIntent);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();

        final String storedLogin = PreferenceUtils.getStoredLogin();

        if ((!TextUtils.isEmpty(storedLogin))){
            final Intent homeIntent = getHomeActivityIntent(storedLogin);
            startActivity(homeIntent);
        }
    }

    @Override
    public void onClick(View view) {

        if (TextUtils.isEmpty(loginEditText.getText())){
            Toast.makeText(this," Empty Login !", Toast.LENGTH_LONG).show();
            return;
        }

        // Before launching the second Activity, just save the values in SharedPreferences
        PreferenceUtils.setLogin(loginEditText.getText().toString());

        final Intent homeIntent = getHomeActivityIntent(loginEditText.getText().toString());
        startActivity(homeIntent);

    }

    private Intent getHomeActivityIntent(String login){
        final Intent intent = new Intent(this, QuizHomeActivity.class);
        final Bundle extras = new Bundle();
        extras.putString("Login",login);
        intent.putExtras(extras);
        return intent;
    }

}
