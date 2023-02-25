package com.example.geektools;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

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

import com.google.firebase.auth.FirebaseAuth;

public class Login_User extends AppCompatActivity {
    private Button button;
    private final FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        Button button = findViewById(R.id.button);
        if(auth.getCurrentUser()!=null){
            Intent i = new Intent(Login_User.this, Drawer.class);
            startActivity(i);
            finish();

        }
        button.setOnClickListener(view ->{
            String txt_email = email.getText().toString();
            String txt_password = password.getText().toString();

            if (TextUtils.isEmpty(txt_email)){
                email.setError("Enter Email");
                return;
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(txt_email).matches()){
                email.setError("Please enter a valid email address");
                return;
            }
            if (TextUtils.isEmpty(txt_password)){
                password.setError("Enter Password");
                return;
            }
                loginUser(txt_email, txt_password);
        });

    }

    private void loginUser (String email, String password){
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(authResult -> {
            Toast.makeText(Login_User.this, "Login successful", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Login_User.this, Drawer.class);
            startActivity(i);
            finish();
        });
        auth.signInWithEmailAndPassword(email, password).addOnFailureListener(authResult ->
                Toast.makeText(Login_User.this, "Email and Password does not match", Toast.LENGTH_SHORT).show());

    }

}

