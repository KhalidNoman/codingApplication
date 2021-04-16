package com.example.codingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class examplesMenu extends AppCompatActivity {

    private Button btnPrimitivesE;
    private Button btnObjectsE;
    private Button btnConditionals;
    private Button btnLoopsE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examples_menu);

        btnPrimitivesE = (Button) findViewById(R.id.btnPrimitivesE);
        btnPrimitivesE.setOnClickListener((view) -> {
            Intent intent = new Intent(examplesMenu.this, examplesPage.class);
            startActivity(intent);
        });

        btnObjectsE = (Button) findViewById(R.id.btnObjectsE);
        btnObjectsE.setOnClickListener((view) -> {
            Intent intent = new Intent(examplesMenu.this, examplesPage.class);
            startActivity(intent);
        });

        btnConditionals = (Button) findViewById(R.id.btnConditionalsE);
        btnConditionals.setOnClickListener((view -> {
            Intent intent = new Intent(examplesMenu.this, examples_Conditionals.class);
            startActivity(intent);
        }));

        btnLoopsE = (Button) findViewById(R.id.btnLoopsE);
        btnLoopsE.setOnClickListener((view) -> {
            Intent intent = new Intent(examplesMenu.this, examples_Loops.class);
            startActivity(intent);
        });

    }
}