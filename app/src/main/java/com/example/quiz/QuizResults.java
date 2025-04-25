package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class QuizResults extends AppCompatActivity {

    private TextView correctText, incorrectText, scoreText, messageText;
    private Button newQuizBtn, reviewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);

        initViews();
        displayResults();
        setupListeners();
    }

    private void initViews() {
        correctText = findViewById(R.id.correctAnswers);
        incorrectText = findViewById(R.id.incorrectAnswers);
        scoreText = findViewById(R.id.scorePercentage);
        messageText = findViewById(R.id.resultMessage);
        newQuizBtn = findViewById(R.id.startNewQuizBtn);
        reviewBtn = findViewById(R.id.viewAnswersBtn);
    }

    private void displayResults() {
        Bundle extras = getIntent().getExtras();
        int correct = extras != null ? extras.getInt("correct", 0) : 0;
        int incorrect = extras != null ? extras.getInt("incorrect", 0) : 0;
        int total = correct + incorrect;

        int percent = total > 0 ? (correct * 100) / total : 0;

        correctText.setText("Correct: " + correct);
        incorrectText.setText("Incorrect: " + incorrect);
        scoreText.setText("Score: " + percent + "%");

        String message;
        if (percent >= 90) {
            message = "Excellent!";
        } else if (percent >= 70) {
            message = "Good job!";
        } else if (percent >= 50) {
            message = "Not bad!";
        } else {
            message = "Keep trying!";
        }
        messageText.setText(message);
    }

    private void setupListeners() {
        newQuizBtn.setOnClickListener(v -> {
            Intent intent = new Intent(QuizResults.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });

        reviewBtn.setOnClickListener(v -> {
            Intent intent = new Intent(QuizResults.this, ReviewAnswersActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
