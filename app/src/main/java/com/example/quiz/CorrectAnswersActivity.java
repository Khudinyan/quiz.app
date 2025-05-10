package com.example.quiz;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CorrectAnswersActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct_answers);

        recyclerView = findViewById(R.id.recyclerView);

        ArrayList<QuestionModel> questionList = (ArrayList<QuestionModel>) getIntent().getSerializableExtra("questions");
        ArrayList<String> userAnswers = getIntent().getStringArrayListExtra("userAnswers");

        if (questionList == null || userAnswers == null) {
            Toast.makeText(this, "Нет данных для отображения", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AnswerAdapter(questionList, userAnswers));
    }
}
