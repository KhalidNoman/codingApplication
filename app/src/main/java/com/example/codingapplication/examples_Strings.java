package com.example.codingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class examples_Strings extends AppCompatActivity {

    private TextView exaOperationStrings;
    private TextView exaOutputStrings;
    private EditText exaValueStrings;
    private Button exaBtnExecuteStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examples__strings);

        exaOperationStrings = findViewById(R.id.exaOperationStrings);
        exaOutputStrings = findViewById(R.id.exaOutputStrings);
        exaValueStrings = findViewById(R.id.exaValueStrings);
        exaBtnExecuteStrings = findViewById(R.id.exaBtnExecuteStrings);

        exaOperationStrings.setText("System.out.println(\"Length: \" + var1.length());\nSystem.out.println(\"First character: \" + var1.chartAt(0));" +
                "\nSystem.out.println(\"Concatenated: \" + var1.concat(\"Concat\");" +
                "\nSystem.out.println(\"Matches hello: \" + var1.matches(\"hello\");" +
                "\nSystem.out.println(\"Replace as with ls: \" + var1.replace('a','l'));");

        exaBtnExecuteStrings.setOnClickListener((View) -> {
            String temp = exaValueStrings.getText().toString();
            exaOutputStrings.setText("Length: " + temp.length() + "\nFirst character: " + temp.charAt(0) + "\nConcatenated: " +
                    temp.concat("hello") + "\nMatches hello: " + temp.matches("hello") + "\nReplace as with ls: " + temp.replace('a', 'l'));
            exaOutputStrings.setText(exaOutputStrings.getText().toString().concat("\nThe value of var1 is: " + temp));
        });
    }
}