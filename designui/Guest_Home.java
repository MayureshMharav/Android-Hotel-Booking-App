package com.firstapp.designui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.HapticFeedbackConstants;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Guest_Home extends AppCompatActivity {

    TextView tvUsername;
    Button Book_btn , About_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_home);

        tvUsername = findViewById(R.id.Username_tv);
        Book_btn = findViewById(R.id.home_book_btn);
        About_btn = findViewById(R.id.about_button);

        // ✅ Read username from SharedPreferences
        SharedPreferences sp = getSharedPreferences("APP_PREFS", MODE_PRIVATE);
        String username = sp.getString("NAME", "name");

        // ✅ Display username
        tvUsername.setText("Welcome, " + username);

        Book_btn.setOnClickListener(v -> {
            Intent Book_btn_int = new Intent(this,Book_Room.class);
            startActivity(Book_btn_int);
        });

        About_btn.setOnClickListener(v -> {
            Intent About_btn_int = new Intent(this,About.class);
            startActivity(About_btn_int);
        });
    }
}
