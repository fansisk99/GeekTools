package com.example.geektools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class SignUp_User extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_user);

        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password_toggle);
        Button loginbtm= findViewById(R.id.loginbtm);


        loginbtm.setOnClickListener(View ->{
            String textEmail = email.getText().toString();
            String textpassword = password.getText().toString();
            if (TextUtils.isEmpty(textEmail)) {
                email.setError("Enter Email");
                return;
            }  if (TextUtils.isEmpty(textpassword)) {
                password.setError("Enter Password");
                return;
            }  if (!Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()) {
                email.setError("Please enter a valid email address");
                return;
            }
            //PerformAuth(textEmail, textpassword);
        });
    }
    public void Newsfeed() {
        Intent intent1 = new Intent(this, Drawer.class);
        startActivity(intent1);
    }

}
