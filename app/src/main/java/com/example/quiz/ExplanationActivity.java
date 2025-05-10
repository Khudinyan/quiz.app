package com.example.quiz;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ExplanationActivity extends AppCompatActivity {

    private TextView questionText, yourAnswerText, correctAnswerText, explanationText;
    private Button nextButton;
    private ImageView imageView;

    private List<QuestionsList> questionsList;
    private int currentIndex = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explanation);

        questionText = findViewById(R.id.questionText);
        yourAnswerText = findViewById(R.id.yourAnswerText);
        correctAnswerText = findViewById(R.id.correctAnswerText);
        explanationText = findViewById(R.id.explanationText);
        imageView = findViewById(R.id.imageView);
        nextButton = findViewById(R.id.nextButton);

        questionsList = (List<QuestionsList>) getIntent().getSerializableExtra("questions");

        if (questionsList != null && !questionsList.isEmpty()) {
            showExplanation();
        } else {
            finish(); // Закрыть, если ничего не передано
        }

        nextButton.setOnClickListener(v -> {
            currentIndex++;
            if (currentIndex < questionsList.size()) {
                showExplanation();
            } else {
                finish(); // Закрыть, когда всё показано
            }
        });
    }

    private void showExplanation() {
        QuestionsList question = questionsList.get(currentIndex);
        questionText.setText(question.getQuestion());
        yourAnswerText.setText("Your Answer: " + question.getUserSelectedAnswer());
        correctAnswerText.setText("Correct Answer: " + question.getAnswer());
        explanationText.setText("Explanation: " + question.getExplanation());

        if (question.hasImage()) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(question.getImageResource());
        } else {
            imageView.setVisibility(View.GONE);
        }
    }
}
