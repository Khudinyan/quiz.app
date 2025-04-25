package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    private String selectedTopic = ""; // Тема викторины
    private CardView capitalLayout, flagsLayout, continentsLayout;
    private Button startQuizBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация UI элементов
        capitalLayout = findViewById(R.id.capitalLayout);
        flagsLayout = findViewById(R.id.flagsMainLayout);
        continentsLayout = findViewById(R.id.continentsLayout);
        startQuizBtn = findViewById(R.id.startQuizBtn);

        // Обработчик нажатия на карточки викторин
        View.OnClickListener topicClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Сброс фона всех карточек
                capitalLayout.setBackgroundResource(R.drawable.round_back_white10);
                flagsLayout.setBackgroundResource(R.drawable.round_back_white10);
                continentsLayout.setBackgroundResource(R.drawable.round_back_white10);

                // Выбор карточки и установка зелёной рамки
                if (v == capitalLayout) {
                    selectedTopic = "capital";
                    capitalLayout.setBackgroundResource(R.drawable.round_back_white_stroke10);
                } else if (v == flagsLayout) {
                    selectedTopic = "flags";
                    flagsLayout.setBackgroundResource(R.drawable.round_back_white_stroke10); // 🟢 ВОТ ОНА!
                } else if (v == continentsLayout) {
                    selectedTopic = "continents";
                    continentsLayout.setBackgroundResource(R.drawable.round_back_white_stroke10);
                }
            }
        };

        // Назначаем клики карточкам
        capitalLayout.setOnClickListener(topicClickListener);
        flagsLayout.setOnClickListener(topicClickListener);
        continentsLayout.setOnClickListener(topicClickListener);

        // Кнопка "Начать"
        startQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedTopic.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Выберите тему викторины!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    intent.putExtra("selectedTopic", selectedTopic);
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            }
        });
    }
}
