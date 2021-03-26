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
/*

        qstText.setText("Select the data type that would best represent the data: ");
        qstCode.setText("... x = 312.245");
        qstChoice1.setText("int");
        qstChoice2.setText("double");
        qstChoice3.setText("boolean");
        qstChoice4.setText("char");
*/
        String[] myChoices = {"int", "double", "boolean", "char"};
        questionData myQuestion = new questionData("Select the data type that would best represent the data: ",
                                    "... x = 312.245", myChoices, "double");
        setQuestion(myQuestion);

        qstChoices.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                qstChoice = findViewById(qstChoices.getCheckedRadioButtonId());
                qstCode.setText(qstChoice.getText().toString() + " x = 312.245");
            }
        });

        btnQstSubmit.setOnClickListener((view) -> {
            try {
                qstChoice = findViewById(qstChoices.getCheckedRadioButtonId());
                if (qstChoice.getText().toString().equals(myQuestion.getAnswer()))
                    Toast.makeText(questionsPage.this, "Correct: The value is of the floating point type", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(questionsPage.this, "Incorrect please try again", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(questionsPage.this, "Please select one of the options!", Toast.LENGTH_LONG).show();
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