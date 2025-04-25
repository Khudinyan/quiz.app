package com.example.quiz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {

    private TextView questions, question;
    private AppCompatButton option1, option2, option3, option4, nextBtn, backBtn;
    private Timer quizTimer;
    private int seconds = 0;
    private int totalTimeInMins = 2; // Установим 2 минуты для таймера

    private List<QuestionsList> questionsList;
    private int currentQuestionPosition = 0;
    private String selectedOptionByUser = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        initViews();
        loadQuestions();
        showCurrentQuestion();
        setupOptionClickListeners();
        setupNextButtonListener();
        setupBackButtonListener();
    }

    private void initViews() {
        final TextView timer = findViewById(R.id.timer);
        questions = findViewById(R.id.questions);
        question = findViewById(R.id.question);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        nextBtn = findViewById(R.id.nextBtn);
        backBtn = findViewById(R.id.backBtn);
        startTimer(timer);
    }

    private void startTimer(final TextView timerTextView) {
        quizTimer = new Timer();
        timerTextView.setTextColor(Color.BLACK);

        // Таймер на 2 минуты
        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    if (seconds == 0) {
                        if (totalTimeInMins == 0) {
                            quizTimer.cancel();
                            timerTextView.setText("00:00");
                            timerTextView.setTextColor(Color.RED);
                            Toast.makeText(QuizActivity.this, "Время вышло!", Toast.LENGTH_SHORT).show();
                            goToResults();
                            return;
                        }
                        totalTimeInMins--;
                        seconds = 59;
                    } else {
                        seconds--;
                    }

                    String timeText = String.format("%02d:%02d", totalTimeInMins, seconds);
                    timerTextView.setText(timeText);

                    // Меняем цвет на красный, если время заканчивается
                    if (totalTimeInMins == 0 && seconds <= 10) {
                        timerTextView.setTextColor(Color.RED);
                    }

                    if (totalTimeInMins == 0 && seconds == 1) {
                        Toast.makeText(QuizActivity.this, "Осталась 1 секунда!", Toast.LENGTH_SHORT).show();
                        vibrateDevice();
                    }
                });
            }
        }, 0, 1000);
    }

    private void vibrateDevice() {
        try {
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (vibrator != null && vibrator.hasVibrator()) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(500);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadQuestions() {
        String getSelectedTopic = getIntent().getStringExtra("selectedTopic");
        questionsList = QuestionsBank.getQuestions(getSelectedTopic);
    }

    private void showCurrentQuestion() {
        if (currentQuestionPosition < questionsList.size()) {
            questions.setText((currentQuestionPosition + 1) + "/" + questionsList.size());
            QuestionsList currentQuestion = questionsList.get(currentQuestionPosition);
            question.setText(currentQuestion.getQuestion());
            option1.setText(currentQuestion.getOption1());
            option2.setText(currentQuestion.getOption2());
            option3.setText(currentQuestion.getOption3());
            option4.setText(currentQuestion.getOption4());

            resetOptionsAppearance();
            restorePreviousSelection();
        }
    }

    private void resetOptionsAppearance() {
        int normalBackground = R.drawable.round_back_white_stroke2_10;
        int textColor = Color.parseColor("#1F6BBB");

        option1.setBackgroundResource(normalBackground);
        option1.setTextColor(textColor);
        option2.setBackgroundResource(normalBackground);
        option2.setTextColor(textColor);
        option3.setBackgroundResource(normalBackground);
        option3.setTextColor(textColor);
        option4.setBackgroundResource(normalBackground);
        option4.setTextColor(textColor);

        selectedOptionByUser = "";
    }

    private void restorePreviousSelection() {
        String previousAnswer = questionsList.get(currentQuestionPosition).getUserSelectedAnswer();
        if (previousAnswer != null && !previousAnswer.isEmpty()) {
            selectedOptionByUser = previousAnswer;
            highlightSelectedOption(previousAnswer);
            revealAnswer();
        }
    }

    private void highlightSelectedOption(String answer) {
        int selectedBackground = R.drawable.round_back_red;
        int textColor = Color.WHITE;

        if (option1.getText().toString().equals(answer)) {
            option1.setBackgroundResource(selectedBackground);
            option1.setTextColor(textColor);
        } else if (option2.getText().toString().equals(answer)) {
            option2.setBackgroundResource(selectedBackground);
            option2.setTextColor(textColor);
        } else if (option3.getText().toString().equals(answer)) {
            option3.setBackgroundResource(selectedBackground);
            option3.setTextColor(textColor);
        } else if (option4.getText().toString().equals(answer)) {
            option4.setBackgroundResource(selectedBackground);
            option4.setTextColor(textColor);
        }
    }

    private void setupOptionClickListeners() {
        View.OnClickListener optionClickListener = v -> {
            if (selectedOptionByUser.isEmpty()) {
                AppCompatButton selectedOption = (AppCompatButton) v;
                selectedOptionByUser = selectedOption.getText().toString();
                selectedOption.setBackgroundResource(R.drawable.round_back_red);
                selectedOption.setTextColor(Color.WHITE);
                revealAnswer();
                questionsList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
            }
        };

        option1.setOnClickListener(optionClickListener);
        option2.setOnClickListener(optionClickListener);
        option3.setOnClickListener(optionClickListener);
        option4.setOnClickListener(optionClickListener);
    }

    private void revealAnswer() {
        final String correctAnswer = questionsList.get(currentQuestionPosition).getAnswer();
        int correctBackground = R.drawable.round_back_green10;
        int textColor = Color.WHITE;

        if (option1.getText().toString().equals(correctAnswer)) {
            option1.setBackgroundResource(correctBackground);
            option1.setTextColor(textColor);
        } else if (option2.getText().toString().equals(correctAnswer)) {
            option2.setBackgroundResource(correctBackground);
            option2.setTextColor(textColor);
        } else if (option3.getText().toString().equals(correctAnswer)) {
            option3.setBackgroundResource(correctBackground);
            option3.setTextColor(textColor);
        } else if (option4.getText().toString().equals(correctAnswer)) {
            option4.setBackgroundResource(correctBackground);
            option4.setTextColor(textColor);
        }
    }

    private void setupNextButtonListener() {
        nextBtn.setOnClickListener(v -> {
            if (selectedOptionByUser.isEmpty()) {
                Toast.makeText(QuizActivity.this, "Пожалуйста, сделайте выбор", Toast.LENGTH_SHORT).show();
            } else {
                if (currentQuestionPosition < questionsList.size() - 1) {
                    currentQuestionPosition++;
                    showCurrentQuestion();
                } else {
                    goToResults();
                }
            }
        });
    }

    private void goToResults() {
        if (quizTimer != null) {
            quizTimer.cancel();
        }

        Intent intent = new Intent(QuizActivity.this, QuizResults.class);
        intent.putExtra("correct", getCorrectAnswers());
        intent.putExtra("incorrect", getInCorrectAnswers());
        startActivity(intent);
        finish();
    }

    private int getCorrectAnswers() {
        int correct = 0;
        for (QuestionsList q : questionsList) {
            if (q.getUserSelectedAnswer() != null &&
                    q.getUserSelectedAnswer().equals(q.getAnswer())) {
                correct++;
            }
        }
        return correct;
    }

    private int getInCorrectAnswers() {
        return questionsList.size() - getCorrectAnswers();
    }

    private void setupBackButtonListener() {
        backBtn.setOnClickListener(v -> {
            if (currentQuestionPosition > 0) {
                currentQuestionPosition--;
                showCurrentQuestion();
            } else {
                showExitConfirmationDialog();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (currentQuestionPosition > 0) {
            currentQuestionPosition--;
            showCurrentQuestion();
        } else {
            showExitConfirmationDialog();
        }
    }

    private void showExitConfirmationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Подтверждение выхода")
                .setMessage("Вы действительно хотите выйти из викторины?")
                .setPositiveButton("Да", (dialog, which) -> {
                    if (quizTimer != null) {
                        quizTimer.cancel();
                    }
                    finish();
                })
                .setNegativeButton("Нет", null)
                .setCancelable(true)
                .show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (quizTimer != null) {
            quizTimer.cancel();
        }
    }
}
