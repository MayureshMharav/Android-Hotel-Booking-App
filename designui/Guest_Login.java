package com.firstapp.designui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Guest_Login extends AppCompatActivity {

    private EditText etName, etEmail;
    private Button btnLogin;

    private FirebaseAuth auth;
    private FirebaseFirestore db;

    private static final String TAG = "Guest_Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_login);

        etName = findViewById(R.id.username_et);
        etEmail = findViewById(R.id.email_et);
        btnLogin = findViewById(R.id.login_btn);

        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        btnLogin.setOnClickListener(v -> loginGuest());
    }

    private void loginGuest() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();

        if (name.isEmpty()) {
            etName.setError("Name required");
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Invalid email");
            return;
        }

        String password = "default123";

        auth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> {
                    Log.d(TAG, "User created");
                    saveUserToFirestore(name, email);
                })
                .addOnFailureListener(e -> {
                    Log.d(TAG, "User exists, trying login");
                    auth.signInWithEmailAndPassword(email, password)
                            .addOnSuccessListener(result ->
                                    saveUserToFirestore(name, email))
                            .addOnFailureListener(err ->
                                    Toast.makeText(this,
                                            "Login failed: " + err.getMessage(),
                                            Toast.LENGTH_LONG).show());
                });
    }

    private void saveUserToFirestore(String name, String email) {
        FirebaseUser user = auth.getCurrentUser();

        if (user == null) {
            Toast.makeText(this, "Auth error", Toast.LENGTH_SHORT).show();
            return;
        }

        Map<String, Object> userData = new HashMap<>();
        userData.put("name", name);
        userData.put("email", email);
        userData.put("role", "GUEST");

        db.collection("users")
                .document(user.getUid())
                .set(userData)
                .addOnSuccessListener(unused -> {
                    Log.d(TAG, "Firestore write success");

                    SharedPreferences sp =
                            getSharedPreferences("APP_PREFS", MODE_PRIVATE);
                    sp.edit()
                            .putBoolean("IS_LOGGED_IN", true)
                            .putString("ROLE", "GUEST")
                            .putString("NAME", name)
                            .apply();

                    startActivity(new Intent(this, Guest_Home.class));
                    finish();
                })
                .addOnFailureListener(e -> {
                    Log.e(TAG, "Firestore error", e);
                    Toast.makeText(this,
                            "Database error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                });
    }
}
