package com.example.geektools;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttoncreate = findViewById(R.id.sing_up);
        Button buttonuser = findViewById(R.id.sing_in);

        buttoncreate.setOnClickListener(this);
        buttonuser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sing_up:
                Intent intent1 = new Intent (this, SignUp_User.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.sing_in:
                Intent intent2 = new Intent (this, Login_User.class);
                startActivity(intent2);
                finish();
                break;
        }
    }
}