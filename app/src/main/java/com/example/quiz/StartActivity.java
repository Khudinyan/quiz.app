package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start); // ВАЖНО!!!

        new Handler().postDelayed(() -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }, 1000); // Задержка 1 сек
    }

    @Override
    public void onBackPressed() {
        // Блокируем назад
    }
}
