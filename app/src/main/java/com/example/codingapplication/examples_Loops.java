package com.example.codingapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class examples_Loops extends AppCompatActivity {

    private TextView exaDragFor;
    private TextView exaDragWhile;
    private TextView exaDragDoWhile;

    private ScrollView exaScrollerLoop;
    private LinearLayout exaLoopContainer;

    private Button exaLoopButton;
    private TextView exaLoopResult;

    String dragged ="", loop = "";
    boolean hasLoop = false;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examples__loops);

        exaDragFor = findViewById(R.id.exaDragFor);
        exaDragWhile = findViewById(R.id.exaDragWhile);
        exaDragDoWhile = findViewById(R.id.exaDragDoWhile);

        exaScrollerLoop = findViewById(R.id.exaScrollerLoops);
        exaLoopContainer = findViewById(R.id.exaLoopContainer);

        exaLoopButton = findViewById(R.id.exaLoopButton);
        exaLoopResult = findViewById(R.id.exaLoopResult);

        final String[] userVal = {"","",""};

        exaDragFor.setOnTouchListener((view, motionEvent) -> {
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                ClipData data = ClipData.newPlainText("For","for");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                dragged = "for";
                return true;
            } else {return false;}
        });

        exaDragWhile.setOnTouchListener((view, motionEvent) -> {
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                ClipData data = ClipData.newPlainText("While","while");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                dragged = "while";
                return true;
            } else {return false;}
        });

        exaDragDoWhile.setOnTouchListener((view, motionEvent) -> {
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                ClipData data = ClipData.newPlainText("Do","do");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                dragged = "do while";
                return true;
            } else {return false;}
        });

        exaScrollerLoop.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                final int action = dragEvent.getAction();
                switch(action){
                    case DragEvent.ACTION_DRAG_STARTED:
                        if(dragEvent.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)){
                            view.setBackgroundColor(Color.YELLOW);
                            view.invalidate();
                            return true;
                        }
                        return false;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        view.setBackgroundColor(Color.GREEN);
                        view.invalidate();
                        return false;
                    case DragEvent.ACTION_DRAG_EXITED:
                        view.setBackgroundColor(Color.YELLOW);
                        view.invalidate();
                        return true;
                    case DragEvent.ACTION_DRAG_ENDED:
                        view.setBackgroundColor(Color.WHITE);
                        view.invalidate();
                        return true;
                    case DragEvent.ACTION_DROP:
                        ClipData.Item item = dragEvent.getClipData().getItemAt(0);
                        CharSequence dragData = item.getText();
                        Toast.makeText(examples_Loops.this, dragData.toString(), Toast.LENGTH_LONG).show();
                        view.setBackgroundColor(Color.WHITE);

                        if(dragData.toString().equals("for")){
                            AlertDialog.Builder userAlert = new AlertDialog.Builder(examples_Loops.this);
                            userAlert.setTitle("Create your loop!");

                            TextView tv=new TextView(examples_Loops.this);
                            tv.setTextSize(20);
                            exaLoopContainer.addView(tv);

                            Context con = examples_Loops.this;
                            LinearLayout conLayout = new LinearLayout(con);
                            conLayout.setOrientation(LinearLayout.VERTICAL);

                            EditText valueHolder = new EditText(con);
                            valueHolder.setHint("Variable value");
                            valueHolder.setInputType(InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_CLASS_NUMBER);
                            conLayout.addView(valueHolder);

                            EditText userCond = new EditText(con);
                            userCond.setHint("condition");
                            userCond.setInputType(InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_CLASS_NUMBER);
                            conLayout.addView(userCond);

                            userAlert.setView(conLayout);
                            userAlert.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    userVal[0] = valueHolder.getText().toString();
                                    userVal[1] = userCond.getText().toString();

                                    if(userVal[0].length() != 0 && userVal[1].length() != 0) {
                                        hasLoop = true;
                                        loop = "for";

                                        tv.setText("int iterations = 0;\n" + dragData.toString().concat("(int i = " + userVal[0] + "; i < " + userVal[1] + "; i++){\n" +
                                                "\t\tSystem.out.println( i + \" for loop\");\n\t\titerations++;\n}\nSystem.out.println(\"Iterations: \" + iterations);"));
                                        ((ViewGroup) exaDragDoWhile.getParent()).removeView(exaDragDoWhile);
                                        ((ViewGroup) exaDragFor.getParent()).removeView(exaDragFor);
                                        ((ViewGroup) exaDragWhile.getParent()).removeView(exaDragWhile);
                                    }
                                }
                            });
                            userAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                            userAlert.show();
                        }else if(dragData.toString().equals("while")){
                            AlertDialog.Builder userAlert = new AlertDialog.Builder(examples_Loops.this);
                            userAlert.setTitle("Create your loop!");

                            TextView tv=new TextView(examples_Loops.this);
                            tv.setTextSize(20);
                            exaLoopContainer.addView(tv);

                            Context con = examples_Loops.this;
                            LinearLayout conLayout = new LinearLayout(con);
                            conLayout.setOrientation(LinearLayout.VERTICAL);

                            EditText valueHolder = new EditText(con);
                            valueHolder.setHint("Variable value");
                            valueHolder.setInputType(InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_CLASS_NUMBER);
                            conLayout.addView(valueHolder);

                            EditText userCond = new EditText(con);
                            userCond.setHint("condition");
                            userCond.setInputType(InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_CLASS_NUMBER);
                            conLayout.addView(userCond);

                            userAlert.setView(conLayout);
                            userAlert.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    userVal[0] = valueHolder.getText().toString();
                                    userVal[1] = userCond.getText().toString();

                                    if(userVal[0].length() != 0 && userVal[1].length() != 0) {
                                        hasLoop = true;
                                        loop = "while";

                                        tv.setText("int iterations = 0;\nint x = " + userVal[0] +";\n" + dragData.toString().concat("(x <= " + userVal[1] + "){\n" +
                                                "\t\tx = x * 2;\n\t\titerations++;\n\t\tSystem.out.println(\"x: \"+ x);\n}\nSystem.out.println(\"Iterations: \" + iterations);"));
                                        ((ViewGroup) exaDragDoWhile.getParent()).removeView(exaDragDoWhile);
                                        ((ViewGroup) exaDragFor.getParent()).removeView(exaDragFor);
                                        ((ViewGroup) exaDragWhile.getParent()).removeView(exaDragWhile);
                                    }
                                }
                            });
                            userAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                            userAlert.show();

                        }else if(dragData.toString().equals("do")){
                            AlertDialog.Builder userAlert = new AlertDialog.Builder(examples_Loops.this);
                            userAlert.setTitle("Create your loop!");

                            TextView tv=new TextView(examples_Loops.this);
                            tv.setTextSize(20);
                            exaLoopContainer.addView(tv);

                            Context con = examples_Loops.this;
                            LinearLayout conLayout = new LinearLayout(con);
                            conLayout.setOrientation(LinearLayout.VERTICAL);

                            EditText valueHolder = new EditText(con);
                            valueHolder.setHint("Variable value");
                            valueHolder.setInputType(InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_CLASS_NUMBER);
                            conLayout.addView(valueHolder);

                            EditText userCond = new EditText(con);
                            userCond.setHint("condition");
                            userCond.setInputType(InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_CLASS_NUMBER);
                            conLayout.addView(userCond);

                            userAlert.setView(conLayout);
                            userAlert.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    userVal[0] = valueHolder.getText().toString();
                                    userVal[1] = userCond.getText().toString();

                                    if(userVal[0].length() != 0 && userVal[1].length() != 0) {
                                        hasLoop = true;
                                        loop = "do";

                                        tv.setText("int iterations = 0;\nint x = " + userVal[0] +";\n" + dragData.toString().concat("{\n" +
                                                "\t\tx = x / 2;\n\t\titerations++;\n\t\tSystem.out.println(\"x: \"+ x);\n}while(x >= " + userVal[1] +");\nSystem.out.println(\"Iterations: \" + iterations);"));
                                        ((ViewGroup) exaDragDoWhile.getParent()).removeView(exaDragDoWhile);
                                        ((ViewGroup) exaDragFor.getParent()).removeView(exaDragFor);
                                        ((ViewGroup) exaDragWhile.getParent()).removeView(exaDragWhile);
                                    }
                                }
                            });
                            userAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                            userAlert.show();

                        }

                        return true;
                    default:
                        return false;
                }
            }
        });

        exaLoopButton.setOnClickListener((view) -> {
            ((ViewGroup) exaLoopButton.getParent()).removeView(exaLoopButton);
            if(hasLoop) {
                if(loop.equalsIgnoreCase("for")){
                    Integer temp = 0;
                    for(int i = Integer.parseInt(userVal[0]); i < Integer.parseInt(userVal[1]); i++) {
                        exaLoopResult.setText(exaLoopResult.getText().toString().concat(i + " for loop\n"));
                        temp++;
                    }
                    exaLoopResult.setText(exaLoopResult.getText().toString().concat("Iterations: " + temp.toString()));
                }
                else if (loop.equalsIgnoreCase("while")){
                    Integer temp = 0, x = Integer.parseInt(userVal[0]), y = Integer.parseInt(userVal[1]);
                    if(x != 0) {
                        while (x <= y) {
                            x = x * 2;
                            exaLoopResult.setText(exaLoopResult.getText().toString().concat("x: " + x.toString() + "\n"));
                            temp++;
                        }
                        exaLoopResult.setText(exaLoopResult.getText().toString().concat("Iterations: " + temp.toString()));
                    } else
                        exaLoopResult.setText(exaLoopResult.getText().toString().concat("infinite loop"));
                }
                else if (loop.equalsIgnoreCase("do")){
                    Integer temp = 0, x = Integer.parseInt(userVal[0]), y = Integer.parseInt(userVal[1]);
                    if(x != 1 && x != 0) {
                        while (x >= y) {
                            x = x / 2;
                            exaLoopResult.setText(exaLoopResult.getText().toString().concat("x: " + x.toString() + "\n"));
                            temp++;
                        }
                        exaLoopResult.setText(exaLoopResult.getText().toString().concat("Iterations: " + temp.toString()));
                    } else
                        exaLoopResult.setText(exaLoopResult.getText().toString().concat("infinite loop"));
                }
            } else
                Toast.makeText(examples_Loops.this, "Please add a loop", Toast.LENGTH_SHORT).show();
        });



    }
}