package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SelectDifficultyActivity extends AppCompatActivity implements View.OnClickListener {

    private String difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_difficulty);

        // Устанавливаем обработчики кликов для кнопок
        findViewById(R.id.easyButton).setOnClickListener(this);
        findViewById(R.id.normalButton).setOnClickListener(this);
        findViewById(R.id.hardButton).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        // Определяем выбранную сложность в зависимости от нажатой кнопки
        if (id == R.id.easyButton) {
            difficulty = "easy";
        } else if (id == R.id.normalButton) {
            difficulty = "normal";
        } else if (id == R.id.hardButton) {
            difficulty = "hard";
        }

        // Переходим к следующей активности с передачей выбранной сложности
        Intent intent = new Intent(SelectDifficultyActivity.this, QuizActivity.class);  // Меняем на QuizActivity
        intent.putExtra("selectedDifficulty", difficulty);  // Передаем выбранный уровень сложности
        startActivity(intent);  // Открываем новую активность
        finish();  // Завершаем текущую активность

    }
}
