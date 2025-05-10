package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start); // Оставляем заставку

        new Handler().postDelayed(() -> {
            // Переход на экран ввода имени
            startActivity(new Intent(this, NameInputActivity.class));
            finish();
        }, 1000); // 1 секунда
    }

    @Override
    public void onBackPressed() {
        // Отключаем кнопку "Назад" на заставке
    }
}
