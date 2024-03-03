package com.example.demo_firebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class InsertData extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TeacherAdapter teacherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        recyclerView = findViewById(R.id.ryc_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<Teacher> options =
                new FirebaseRecyclerOptions.Builder<Teacher>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("teacher"), Teacher.class)
                        .build();

        teacherAdapter = new TeacherAdapter(options);
        recyclerView.setAdapter(teacherAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        teacherAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        teacherAdapter.stopListening();
    }
}