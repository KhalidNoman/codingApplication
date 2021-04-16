package com.example.codingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class questionsPage extends AppCompatActivity {

    private TextView qstText;
    private TextView qstCode;
    private RadioGroup qstChoices;
    private RadioButton qstChoice1;
    private RadioButton qstChoice2;
    private RadioButton qstChoice3;
    private RadioButton qstChoice4;
    private Button btnQstSubmit;
    private RadioButton qstChoice;

    private questionData myQuestion;
    private String[] myChoices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_page);

        qstText = findViewById(R.id.qstText);
        qstCode = findViewById(R.id.qstCode);
        qstChoices = findViewById(R.id.qstChoices);
        qstChoice1 = findViewById(R.id.qstChoice1);
        qstChoice2 = findViewById(R.id.qstChoice2);
        qstChoice3 = findViewById(R.id.qstChoice3);
        qstChoice4 = findViewById(R.id.qstChoice4);
        btnQstSubmit = findViewById(R.id.btnQstSubmit);

        String typeOfQuestion = getIntent().getStringExtra("Type").toString();
/*

        qstText.setText("Select the data type that would best represent the data: ");
        qstCode.setText("... x = 312.245");
        qstChoice1.setText("int");
        qstChoice2.setText("double");
        qstChoice3.setText("boolean");
        qstChoice4.setText("char");
*/
        questionData myQuestion = new questionData();
        if(typeOfQuestion.equalsIgnoreCase("Primitive Data Types")) {
            String[] myChoices = {"int", "double", "boolean", "char"};
            myQuestion = new questionData("Select the data type that would best represent the data: ",
                    "... x = 312.245", myChoices, 1);
            setQuestion(myQuestion);

        } else if(typeOfQuestion.equalsIgnoreCase("Objects (Strings)")) {
            String[] myChoices = {"single quotes, double quotes", "double quotes, single quotes", "single quotes, single quotes", "double quotes, double quotes"};
            myQuestion = new questionData("Character literals are enclosed in ... and string literals are enclosed in ...",
                    "", myChoices, 0);
            setQuestion(myQuestion);

        } else if(typeOfQuestion.equalsIgnoreCase("Conditionals")) {
            String[] myChoices = {"no statements or blocks are executed", "the statement or block following the else is executed",
                    "the first statement or block is executed", "all the statements or blocks are executed"};
            myQuestion = new questionData("In an if-else statement, if the boolean expression is false then: ",
                    "", myChoices, 1);
            setQuestion(myQuestion);

        } else if(typeOfQuestion.equalsIgnoreCase("Loops")) {
            String[] myChoices = {"count-controlled", "infinite", "conditional", "pretest"};
            myQuestion = new questionData("A loop that repeats a specific number of times is known as a(n) __________ loop.",
                    "", myChoices, 0);
            setQuestion(myQuestion);

        }


        qstChoices.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                qstChoice = findViewById(qstChoices.getCheckedRadioButtonId());
                //qstCode.setText(qstChoice.getText().toString() + "x = 312.245");
            }
        });

        questionData finalMyQuestion = myQuestion;
        btnQstSubmit.setOnClickListener((view) -> {
            try {
                qstChoice = findViewById(qstChoices.getCheckedRadioButtonId());
                if (qstChoice.getText().toString().equals(finalMyQuestion.getChoices()[finalMyQuestion.getAnswer()])) {
                    Toast.makeText(questionsPage.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(questionsPage.this, "Incorrect please try again", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(questionsPage.this, "Please select one of the options!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    protected void setQuestion(questionData qst1){
        qstText.setText(qst1.getQuestion());
        qstCode.setText(qst1.getCode());
        qstChoice1.setText(qst1.getChoices()[0]);
        qstChoice2.setText(qst1.getChoices()[1]);
        qstChoice3.setText(qst1.getChoices()[2]);
        qstChoice4.setText(qst1.getChoices()[3]);
    }
}