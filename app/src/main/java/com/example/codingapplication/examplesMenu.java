package com.example.codingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class examplesMenu extends AppCompatActivity {

    private Button btnPrimitivesE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examples_menu);
        btnPrimitivesE = (Button) findViewById(R.id.btnPrimitivesE);
        btnPrimitivesE.setOnClickListener((view) -> {
            Intent intent = new Intent(examplesMenu.this, examplesPage.class);
            startActivity(intent);
        });
    }
}