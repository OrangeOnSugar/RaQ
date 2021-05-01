package com.example.raiq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class Authoriz extends AppCompatActivity {

    Button auth, gowww;
    TextView registr, gotoforgetpass;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authoriz);
        final SharedPreferences sett = this.getApplicationContext().getSharedPreferences("Settings", 0);
        if (sett.getBoolean("DayThem",false) == true)
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        toast = new Toast(getApplicationContext());
        gotoforgetpass = findViewById(R.id.auth_change_password);
        gotoforgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Authoriz.this, forgetpass_activity.class));
                finish();
            }
        });
        auth = findViewById(R.id.auth_comein);
        registr = findViewById(R.id.auth_registr);
        //Вход в аккаунт и открытие главного активити
        auth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Authoriz.this,MainActivity.class);
                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        //Открытие активити регистрации
        registr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Authoriz.this,regisration.class).addFlags(Intent.FLAG_RECEIVER_NO_ABORT));
                finish();
            }
        });
        //Переход на сайт
        gowww = findViewById(R.id.auth_auth_like_a_partn);
        gowww.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowMess();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        toast.cancel();
    }

    @Override
    protected void onStop() {
        super.onStop();
        toast.cancel();
    }

    public void ShowMess()
    {
        LayoutInflater inflater = getLayoutInflater();
        View lay = inflater.inflate(R.layout.activity_notif_message, (ViewGroup) findViewById(R.id.notif_message_root));
        TextView Message_type = lay.findViewById(R.id.notif_message_lable);
        TextView Message_text = lay.findViewById(R.id.notif_message_text);
        Message_text.setText("Suction!");
        toast.setGravity(Gravity.TOP|Gravity.FILL_HORIZONTAL,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(lay);
        toast.show();
    }
}