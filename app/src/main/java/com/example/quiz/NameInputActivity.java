package com.example.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NameInputActivity extends AppCompatActivity {

    private EditText nameEditText;
    private Button continueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_input);

        nameEditText = findViewById(R.id.nameEditText);
        continueBtn = findViewById(R.id.continueBtn);

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String playerName = nameEditText.getText().toString().trim();

                if (playerName.isEmpty()) {
                    Toast.makeText(NameInputActivity.this, "Введите ваше имя!", Toast.LENGTH_SHORT).show();
                } else {
                    // Сохраняем имя игрока в SharedPreferences
                    SharedPreferences prefs = getSharedPreferences("quiz_app", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("playerName", playerName); // Сохраняем имя игрока
                    editor.apply(); // Применяем изменения

                    // Переход на экран выбора темы
                    Intent intent = new Intent(NameInputActivity.this, MainActivity.class);
                    intent.putExtra("playerName", playerName);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
