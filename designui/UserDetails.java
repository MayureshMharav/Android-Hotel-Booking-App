package com.firstapp.designui;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class UserDetails extends AppCompatActivity {

    ListView usersListView;
    ArrayList<String> usersList;
    ArrayAdapter<String> adapter;

    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        usersListView = findViewById(R.id.usersListView);
        usersList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                usersList);

        usersListView.setAdapter(adapter);

        db = FirebaseFirestore.getInstance();

        loadUsers();
    }

    private void loadUsers() {
        db.collection("users")
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    usersList.clear();

                    for (var doc : queryDocumentSnapshots) {
                        String name = doc.getString("name");
                        String email = doc.getString("email");

                        usersList.add("Name: " + name + "\nEmail: " + email);
                    }

                    adapter.notifyDataSetChanged();
                })
                .addOnFailureListener(e ->
                        Toast.makeText(this,
                                "Failed to load users",
                                Toast.LENGTH_SHORT).show());
    }
}
