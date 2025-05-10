package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DifficultySelectionActivity extends AppCompatActivity {

    private Button easyButton, normalButton, hardButton;
    private String playerName, selectedTopic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_difficulty);

        // Получаем переданные данные (имя игрока и тема)
        playerName = getIntent().getStringExtra("playerName");
        selectedTopic = getIntent().getStringExtra("selectedTopic");

        easyButton = findViewById(R.id.easyButton);
        normalButton = findViewById(R.id.normalButton);
        hardButton = findViewById(R.id.hardButton);

        // Устанавливаем обработчики нажатий для кнопок
        easyButton.setOnClickListener(v -> openQuizWithDifficulty("easy"));
        normalButton.setOnClickListener(v -> openQuizWithDifficulty("normal"));
        hardButton.setOnClickListener(v -> openQuizWithDifficulty("hard"));
    }

    private void openQuizWithDifficulty(String difficulty) {
        // Создаем новый Intent для перехода в QuizActivity
        Intent intent = new Intent(DifficultySelectionActivity.this, QuizActivity.class);

        // Передаем необходимые данные (имя игрока, тема и уровень сложности)
        intent.putExtra("playerName", playerName);
        intent.putExtra("selectedTopic", selectedTopic);
        intent.putExtra("difficulty", difficulty);

        // Запускаем QuizActivity
        startActivity(intent);
    }
}
