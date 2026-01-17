package com.firstapp.designui;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sp = getSharedPreferences("APP_PREFS", MODE_PRIVATE);
        boolean loggedIn = sp.getBoolean("IS_LOGGED_IN", false);
        String role = sp.getString("ROLE", "");

        if (loggedIn) {
            if (role.equals("GUEST")) {
                startActivity(new Intent(this, Guest_Home.class));
            } else {
                startActivity(new Intent(this, Admin_Home.class));
            }
            finish();
            return;
        }

        setContentView(R.layout.activity_main);
        showLoginAsDialog();
    }

    private void showLoginAsDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_login_as);
        dialog.setCancelable(false);

        ImageView guest = dialog.findViewById(R.id.btnGuest);
        ImageView admin = dialog.findViewById(R.id.btnAdmin);

        guest.setOnClickListener(v -> {
            dialog.dismiss();
            startActivity(new Intent(this, Guest_Login.class));
            finish();
        });

        admin.setOnClickListener(v -> {
            dialog.dismiss();
            startActivity(new Intent(this, Admin_Login.class));
            finish();
        });

        dialog.show();
    }
}
