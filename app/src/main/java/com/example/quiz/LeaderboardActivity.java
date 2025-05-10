package com.example.quiz;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LeaderboardActivity extends AppCompatActivity {

    private TextView leaderboardText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        leaderboardText = findViewById(R.id.leaderboardText);

        // Retrieve the player's name from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("GamePrefs", MODE_PRIVATE);
        String playerName = sharedPreferences.getString("playerName", "Unknown Player");

        // Display the player's name in the leaderboard text
        leaderboardText.setText("Player: " + playerName);
    }
}
