package com.example.raiq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class regisration extends AppCompatActivity {

    Button createacc;
    TextView backtoauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regisration);
        createacc = findViewById(R.id.regist_sozdat_akk);
        backtoauth = findViewById(R.id.regist_auth);
        backtoauth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(regisration.this,Authoriz.class));
                finish();
            }
        });
    }
}