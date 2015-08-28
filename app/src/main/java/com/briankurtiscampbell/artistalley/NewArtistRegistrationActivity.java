package com.briankurtiscampbell.artistalley;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewArtistRegistrationActivity extends Activity {
    private Button btnSignUp;
    private EditText emailEditText;
    private EditText passEditText;
    private EditText passEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_artist_registration);

        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        emailEditText = (EditText) findViewById(R.id.editTextEmail);
        passEditText = (EditText) findViewById(R.id.editTextPassword);
        passEditText2 = (EditText) findViewById(R.id.editTextPassword2);

        final String email = emailEditText.getText().toString().trim();
        final String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        final String pass = passEditText.getText().toString().trim();
        final String pass2 = passEditText2.getText().toString().trim();

        emailEditText .addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

                if (!email.matches(emailPattern)) {
                    emailEditText.setError("Invalid Email");
                    //or
                } else {
                    Toast.makeText(getApplicationContext(), "valid email address", Toast.LENGTH_SHORT).show();
                    // or
                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // other stuffs
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // other stuffs
            }
        });

        passEditText .addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

                if (passEditText.length() <= 6) {
                    passEditText.setError("Invalid Password");
                }
            }


            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // other stuffs
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // other stuffs
            }
        });

        passEditText2 .addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

                if (passEditText2.length() <= 6) {
                    passEditText2.setError("Invalid Password");
                }

                if (!pass2.equals(pass)) {
                    passEditText2.setError("Passwords do not match!!!");
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // other stuffs
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // other stuffs
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


            }
        });
    }

    // validating email id
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
