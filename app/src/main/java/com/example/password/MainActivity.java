package com.example.password;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.view.View;
import android.util.Patterns;
import java.util.regex.Pattern;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +        //any letter
                    "(?=.*[@#$%^&+=])" +       //at least 1 special character
                    "(?=\\S+$)" +              //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");

    private TextInputLayout textInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textInputPassword = findViewById(R.id.text_input_password);
    }
        private boolean validatePassword() {
            String passwordInput = textInputPassword.getEditText().getText().toString().trim();

            if (passwordInput.isEmpty()) {
                textInputPassword.setError("Field can't be empty");
                return false;
            } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
                textInputPassword.setError("Password too weak");
                return false;
            } else {
                textInputPassword.setError(null);
                return true;
            }
        }

        public void confirmInput(View v) {
            if (!validatePassword()) {
                return;
            }

            input += "Password: " + textInputPassword.getEditText().getText().toString();

            Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
        }




}

