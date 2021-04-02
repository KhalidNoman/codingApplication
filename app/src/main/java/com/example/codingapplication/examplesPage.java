package com.example.codingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class examplesPage extends AppCompatActivity {

    private EditText exaValue;
    private Spinner exaVariableType;
    private TextView exaOperation;
    private TextView exaPrint;
    private TextView exaOutput;
    private TextView exaOuter;
    private TextView exaEnd;
    private Button exaBtnExecute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examples_page);

        examplesData myExample = new examplesData("Add", "public static void main(String args[]){", "firstTry", 10, "}" );

        exaValue = findViewById(R.id.exaValue);
        exaVariableType = findViewById(R.id.exaVariableType);
        exaOperation = findViewById(R.id.exaOperation);
        exaPrint = findViewById(R.id.exaPrint);
        exaOuter = findViewById(R.id.exaOuter);
        exaEnd = findViewById(R.id.exaEnd);
        exaOutput = findViewById(R.id.exaOutput);
        exaBtnExecute = findViewById(R.id.exaBtnExecute);

        exaOuter.setText(myExample.getOuter());
        exaEnd.setText(myExample.getEnd());

        String[] items = {"int","long","float","double","String"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        exaVariableType.setAdapter(adapter);

        exaValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                exaOperation.setText("var1 = " + exaValue.getText() +" * 2;");
            }
        });

        exaBtnExecute.setOnClickListener((view) ->{
            if(exaVariableType.getSelectedItem().toString().equals("double") || exaVariableType.getSelectedItem().toString().equals("float"))
                exaOutput.setText("The value of var1 is: " + Double.parseDouble(exaValue.getText().toString())*2);
            else if(exaVariableType.getSelectedItem().toString().equals("int") || exaVariableType.getSelectedItem().toString().equals("long")) {
                Integer val, pos;
                if(exaValue.getText().toString().contains(".")) {
                    pos = exaValue.getText().toString().indexOf(".");
                    val = Integer.parseInt(exaValue.getText().toString().substring(0, pos));
                } else val = Integer.parseInt(exaValue.getText().toString());
                exaOutput.setText("The value of var1 is: " + val * 2);
            }else
                exaOutput.setText("Syntax error!");
        });
    }
}