package com.example.codingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class questionsMenu extends AppCompatActivity {

    private Button btnPrimitivesQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_menu);
        btnPrimitivesQ = (Button) findViewById(R.id.btnPrimitivesQ);
        btnPrimitivesQ.setOnClickListener((view) -> {
            Intent intent = new Intent(questionsMenu.this, questionsPage.class);
            startActivity(intent);
        });
    }
}