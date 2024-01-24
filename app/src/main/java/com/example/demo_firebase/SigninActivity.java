package com.example.demo_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class SigninActivity extends AppCompatActivity {

    private LinearLayout layoutSingup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        initUI();
        initListener();
    }

    private void initListener() {
        layoutSingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SigninActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initUI() {
        layoutSingup = findViewById(R.id.layout_signup);
    }
}