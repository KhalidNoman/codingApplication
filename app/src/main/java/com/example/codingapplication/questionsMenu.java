package com.example.codingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class questionsMenu extends AppCompatActivity {

    private Button btnPrimitivesQ;
    private Button btnObjectsQ;
    private Button btnConditionalsQ;
    private Button btnLoopsQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_menu);

        btnPrimitivesQ = (Button) findViewById(R.id.btnPrimitivesQ);
        btnObjectsQ = (Button) findViewById(R.id.btnObjectsQ);
        btnConditionalsQ = (Button) findViewById(R.id.btnConditionalsQ);
        btnLoopsQ = (Button) findViewById(R.id.btnLoopsQ);


        btnPrimitivesQ.setOnClickListener((view) -> {
            Intent intent = new Intent(questionsMenu.this, questionsPage.class);
            intent.putExtra("Type", btnPrimitivesQ.getText().toString());
            startActivity(intent);
        });

        btnObjectsQ.setOnClickListener((view) ->{
            Intent intent = new Intent(questionsMenu.this, questionsPage.class);
            intent.putExtra("Type", btnObjectsQ.getText().toString());
            startActivity(intent);
        });

        btnConditionalsQ.setOnClickListener((view) ->{
            Intent intent = new Intent(questionsMenu.this, questionsPage.class);
            intent.putExtra("Type", btnConditionalsQ.getText().toString());
            startActivity(intent);
        });

        btnLoopsQ.setOnClickListener((view) ->{
            Intent intent = new Intent(questionsMenu.this, questionsPage.class);
            intent.putExtra("Type", btnLoopsQ.getText().toString());
            startActivity(intent);
        });
    }
}