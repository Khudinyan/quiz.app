package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // БЫЛО: activity_start ❌ / СТАЛО: activity_menu ✅
        initializeViews();
    }

    private void initializeViews() {
        try {
            Button startButton = findViewById(R.id.startButton);
            Button settingsButton = findViewById(R.id.settingsButton);
            Button exitButton = findViewById(R.id.exitButton);

            startButton.setOnClickListener(v -> navigateTo(MainActivity.class));
            settingsButton.setOnClickListener(v -> showComingSoonToast());
            exitButton.setOnClickListener(v -> showExitDialog());

        } catch (Exception e) {
            showErrorAndFinish("Ошибка инициализации меню");
        }
    }

    private void navigateTo(Class<?> destination) {
        try {
            Intent intent = new Intent(this, destination);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        } catch (Exception e) {
            showErrorToast("Не удалось выполнить переход");
        }
    }

    private void showComingSoonToast() {
        Toast.makeText(this, getString(R.string.coming_soon_message), Toast.LENGTH_SHORT).show();
    }

    private void showExitDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.exit_title)
                .setMessage(R.string.exit_message)
                .setPositiveButton(R.string.yes, (dialog, which) -> closeApp())
                .setNegativeButton(R.string.no, null)
                .setCancelable(false)
                .create()
                .show();
    }

    private void closeApp() {
        finishAffinity();
        System.exit(0);
    }

    private void showErrorAndFinish(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        finish();
    }

    private void showErrorToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        showExitDialog();
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
