package com.example.quiz;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AnswersReviewActivity extends AppCompatActivity {

    private LinearLayout answersContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers_review);

        answersContainer = findViewById(R.id.answersContainer);

        // Получаем данные из Intent
        ArrayList<String> questions = getIntent().getStringArrayListExtra("questions");
        ArrayList<String> correctAnswers = getIntent().getStringArrayListExtra("correctAnswers");
        ArrayList<String> userAnswers = getIntent().getStringArrayListExtra("userAnswers");

        for (int i = 0; i < questions.size(); i++) {
            String questionText = questions.get(i);
            String correct = correctAnswers.get(i);
            String user = userAnswers.get(i);

            TextView textView = new TextView(this);
            textView.setText(
                    "❓ " + questionText + "\n" +
                            "✅ Правильный: " + correct + "\n" +
                            "🧑‍💻 Ваш ответ: " + user + "\n"
            );
            textView.setPadding(0, 20, 0, 20);

            if (correct.equals(user)) {
                textView.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
            } else {
                textView.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }

            answersContainer.addView(textView);
        }
    }
}
