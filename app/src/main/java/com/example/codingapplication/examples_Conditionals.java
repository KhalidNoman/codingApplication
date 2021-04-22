package com.example.codingapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class examples_Conditionals extends AppCompatActivity {

    private TextView exaDragIf;
    private TextView exaDragElseIf;
    private TextView exaDragElse;

    private TextView exaDragSwitch;
    private TextView exaDragCase;
    private TextView exaDragBreak;

    private ScrollView exaScroller;
    private LinearLayout exaCondContainer;

    private Button exaCondButton;
    private TextView exaCondResult;

    boolean hasIf, hasSwitch = false;
    String dragged = "";

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examples__conditionals);

        exaDragIf = (TextView) findViewById(R.id.exaDragIf);
        exaDragElseIf = (TextView) findViewById(R.id.exaDragElseIf);
        exaDragElse = (TextView) findViewById(R.id.exaDragElse);

        exaDragSwitch = (TextView) findViewById(R.id.exaDragSwitch);
        exaDragCase = (TextView) findViewById(R.id.exaDragCase);
        exaDragBreak = (TextView) findViewById(R.id.exaDragBreak);

        exaScroller = (ScrollView) findViewById(R.id.exaScroller);
        exaCondContainer = (LinearLayout) findViewById(R.id.exaCondContainer);

        exaCondButton = (Button) findViewById(R.id.exaCondButton);
        exaCondResult = (TextView) findViewById(R.id.exaCondResult);


        final String[] userVal = {"0","0","0","0"};

        exaDragIf.setOnTouchListener((view, motionEvent) -> {
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                ClipData data = ClipData.newPlainText("If","if");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                dragged = "if";
                return true;
            } else {return false;}
        });

        exaDragElseIf.setOnTouchListener((view, motionEvent) -> {
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                ClipData data = ClipData.newPlainText("Else if","else if");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                dragged = "else if";
                return true;
            } else {return false;}
        });

        exaDragElse.setOnTouchListener((view, motionEvent) -> {
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                ClipData data = ClipData.newPlainText("Else","else");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                dragged = "else";
                return true;
            } else {return false;}
        });


        exaDragSwitch.setOnTouchListener((view, motionEvent) -> {
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                ClipData data = ClipData.newPlainText("Switch","switch");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                dragged = "switch";
                return true;
            } else {return false;}
        });

        exaDragCase.setOnTouchListener((view, motionEvent) -> {
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                ClipData data = ClipData.newPlainText("Case","case");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                dragged = "case";
                return true;
            } else {return false;}
        });

        exaDragBreak.setOnTouchListener((view, motionEvent) -> {
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                ClipData data = ClipData.newPlainText("Break","break");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                dragged = "break";
                return true;
            } else {return false;}
        });


        exaScroller.setOnDragListener(new View.OnDragListener() {
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
                        //String temp = dragEvent.getClipData().getItemAt(0).getText().toString();
                        if((!hasSwitch && (dragged.equals("case") || dragged.equals("break"))) || (!hasIf && (dragged.equals("else") || dragged.equals("else if")))) {
                            view.setBackgroundColor(Color.RED);
                        }else
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
                        Toast.makeText(examples_Conditionals.this, dragData.toString(), Toast.LENGTH_LONG).show();
                        view.setBackgroundColor(Color.WHITE);

                        //Ifs 
                        if(dragData.toString().equals("if")) {
                            hasIf = true;

                            AlertDialog.Builder userAlert = new AlertDialog.Builder(examples_Conditionals.this);
                            userAlert.setTitle("Create your conditional!");

                            TextView tv=new TextView(examples_Conditionals.this);
                            //tv.setText("int x = " + userVal[0] + "\n" + dragData.toString().concat(" (x >" + userVal[1] + ") {"));
                            tv.setTextSize(20);
                            exaCondContainer.addView(tv);

                            Context con = examples_Conditionals.this;
                            LinearLayout conLayout = new LinearLayout(con);
                            conLayout.setOrientation(LinearLayout.VERTICAL);

                            EditText valueHolder = new EditText(con);
                            valueHolder.setHint("Variable value");
                            conLayout.addView(valueHolder);

                            EditText ifPart = new EditText(con);
                            ifPart.setHint("if condition");
                            conLayout.addView(ifPart);

                            /*EditText elseIfPart = new EditText(con);
                            elseIfPart.setHint("else if condition");
                            conLayout.addView(elseIfPart);
                            */

                            userAlert.setView(conLayout);
                            userAlert.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    userVal[0] = valueHolder.getText().toString();
                                    userVal[1] = ifPart.getText().toString();

                                    tv.setText("int x = " + userVal[0] + ";\n" + dragData.toString().concat(" (x <" + userVal[1] + ") {\n" + "\t\tSystem.out.println(\"if satisfied\");\n}"));
                                    ((ViewGroup) exaDragIf.getParent()).removeView(exaDragIf);
                                    ((ViewGroup) exaDragSwitch.getParent()).removeView(exaDragSwitch);
                                    ((ViewGroup) exaDragCase.getParent()).removeView(exaDragCase);
                                    ((ViewGroup) exaDragBreak.getParent()).removeView(exaDragBreak);
                                }
                            });
                            userAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                            userAlert.show();

                        } else if(dragData.toString().equals("else if")){

                            AlertDialog.Builder userAlert = new AlertDialog.Builder(examples_Conditionals.this);
                            userAlert.setTitle("Create your conditional!");

                            TextView tv=new TextView(examples_Conditionals.this);
                            tv.setTextSize(20);
                            exaCondContainer.addView(tv);

                            Context con = examples_Conditionals.this;
                            LinearLayout conLayout = new LinearLayout(con);
                            conLayout.setOrientation(LinearLayout.VERTICAL);

                            EditText elseIfPart = new EditText(con);
                            elseIfPart.setHint("else if condition");
                            elseIfPart.setInputType(InputType.TYPE_CLASS_NUMBER);
                            conLayout.addView(elseIfPart);


                            userAlert.setView(conLayout);
                            userAlert.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    userVal[2] = elseIfPart.getText().toString();

                                    tv.setText(dragData.toString().concat(" (x >" + userVal[2] + ") {\n" + "\t\tSystem.out.println(\"else if satisfied\");\n}"));
                                    ((ViewGroup) exaDragElseIf.getParent()).removeView(exaDragElseIf);
                                }
                            });
                            userAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                            userAlert.show();




                        } else if(dragData.toString().equals("else")){
                            AlertDialog.Builder userAlert = new AlertDialog.Builder(examples_Conditionals.this);
                            userAlert.setTitle("Create your conditional!");

                            TextView tv=new TextView(examples_Conditionals.this);
                            tv.setText(dragData.toString().concat("{\n" + "\t\tSystem.out.println(\"else satisfied\");\n}"));
                            tv.setTextSize(20);
                            exaCondContainer.addView(tv);

                            ((ViewGroup) exaDragElse.getParent()).removeView(exaDragElse);
                        }
                        //Switches
                        else if (dragData.toString().equals("switch")) {
                            hasSwitch = true;

                            ((ViewGroup) exaDragIf.getParent()).removeView(exaDragIf);
                            ((ViewGroup) exaDragElseIf.getParent()).removeView(exaDragElseIf);
                            ((ViewGroup) exaDragElse.getParent()).removeView(exaDragElse);

                        }else if (dragData.toString().equals("case")) {

                        }else if (dragData.toString().equals("break")) {

                        }
                        view.invalidate();
                        return true;
                    default:
                        return false;
                }
            }
        });

        exaCondButton.setOnClickListener((view) -> {
            if(Integer.parseInt(userVal[0]) > Integer.parseInt(userVal[1])){
                exaCondResult.setText("if satisfied");
            } else if (Integer.parseInt(userVal[0]) < Integer.parseInt(userVal[2])){
                exaCondResult.setText("else if satisfied");
            } else {
                exaCondResult.setText("else satisfied");
            }
        });


    }


}