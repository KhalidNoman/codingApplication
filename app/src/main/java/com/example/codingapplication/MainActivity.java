package com.example.codingapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnQuestions;
    private Button btnExamples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnQuestions = (Button) findViewById(R.id.btnQuestions);
        btnQuestions.setOnClickListener((view) -> {
            Intent intent = new Intent(MainActivity.this, questionsMenu.class);
            startActivity(intent);
        });

        btnExamples = (Button) findViewById(R.id.btnExamples);
        btnExamples.setOnClickListener((view) -> {
            Intent intent = new Intent(MainActivity.this, examplesMenu.class);
            startActivity(intent);
        });
    }

}