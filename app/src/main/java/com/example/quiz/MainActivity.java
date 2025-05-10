package com.example.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    private String selectedTopic = "";
    private String selectedLevel="";
    private String playerName = ""; // имя игрока
    private CardView capitalLayout, flagsLayout, continentsLayout;
    private Button startQuizBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Получаем имя игрока из предыдущей активности
        playerName = getIntent().getStringExtra("playerName");
        if (playerName == null) {
            playerName = "";  // Установить пустую строку, если имя не передано
        }


        capitalLayout = findViewById(R.id.capitalLayout);
        flagsLayout = findViewById(R.id.flagsMainLayout);
        continentsLayout = findViewById(R.id.continentsLayout);
        startQuizBtn = findViewById(R.id.startQuizBtn);

        // Устанавливаем слушатели на выбор темы
        View.OnClickListener topicClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTopicSelection();  // Сбросим выделение всех тем

                // Выбираем тему в зависимости от нажатой кнопки
                if (v == capitalLayout) {
                    selectedTopic = "capital";
                    capitalLayout.setBackgroundResource(R.drawable.round_back_white_stroke10);
                } else if (v == flagsLayout) {
                    selectedTopic = "flags";
                    flagsLayout.setBackgroundResource(R.drawable.round_back_white_stroke10);
                } else if (v == continentsLayout) {
                    selectedTopic = "continents";
                    continentsLayout.setBackgroundResource(R.drawable.round_back_white_stroke10);
                }
            }
        };

        // Привязываем слушатели к каждой карточке
        capitalLayout.setOnClickListener(topicClickListener);
        flagsLayout.setOnClickListener(topicClickListener);
        continentsLayout.setOnClickListener(topicClickListener);

        // Настроим кнопку старта викторины
        startQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedTopic.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Выберите тему викторины!", Toast.LENGTH_SHORT).show();
                } else {
                    // Переход к активности выбора сложности
                    Intent intent = new Intent(MainActivity.this, DifficultySelectionActivity.class);
                    intent.putExtra("selectedTopic", selectedTopic);
                    intent.putExtra("playerName", playerName);  // передаем имя игрока
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            }
        });
    }

    // Сбрасываем выделение всех тем
    private void resetTopicSelection() {
        capitalLayout.setBackgroundResource(R.drawable.round_back_white10);
        flagsLayout.setBackgroundResource(R.drawable.round_back_white10);
        continentsLayout.setBackgroundResource(R.drawable.round_back_white10);
    }

    // Метод для перезапуска игры
    public void restartGame() {
        SharedPreferences prefs = getSharedPreferences("quiz_app", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("playerName", ""); // очищаем имя игрока
        editor.putString("selectedTopic", ""); // очищаем выбранную тему
        editor.apply(); // применяем изменения

        // Перенаправляем на экран выбора викторины
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    // Метод для проверки имени перед началом викторины
    public void checkPlayerNameAndStart() {
        SharedPreferences prefs = getSharedPreferences("quiz_app", MODE_PRIVATE);
        String playerName = prefs.getString("playerName", null); // получаем имя игрока из SharedPreferences

        if (playerName == null || playerName.isEmpty()) {
            // Если имя пустое или не задано, показываем уведомление и даем возможность выбрать викторину
            Toast.makeText(MainActivity.this, "Выберите викторину и начинайте заново", Toast.LENGTH_SHORT).show();

            // Очищаем все выбранные данные и показываем экран выбора викторины
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("selectedTopic", "");  // Сбрасываем выбранную тему
            editor.apply();

            // Переход на экран выбора викторины
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            // Если имя задано, продолжим игру
            // (здесь можно добавить логику для начала игры, используя имя и выбранную тему)
        }
    }
}
