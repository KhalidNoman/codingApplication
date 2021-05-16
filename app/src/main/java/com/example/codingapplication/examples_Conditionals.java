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

import java.util.Arrays;

public class examples_Conditionals extends AppCompatActivity {

    private TextView exaDragIf;
    private TextView exaDragElseIf;
    private TextView exaDragElse;

    private TextView exaDragSwitch;
    private TextView exaDragCase;
    private TextView exaDragDefault;

    private ScrollView exaScroller;
    private LinearLayout exaCondContainer;

    private Button exaCondButton;
    private TextView exaCondResult;

    boolean hasIf, hasSwitch, hasDefault, hasElse = false;
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
        exaDragDefault = (TextView) findViewById(R.id.exaDragDefault);

        exaScroller = (ScrollView) findViewById(R.id.exaScroller);
        exaCondContainer = (LinearLayout) findViewById(R.id.exaCondContainer);

        exaCondButton = (Button) findViewById(R.id.exaCondButton);
        exaCondResult = (TextView) findViewById(R.id.exaCondResult);


        final String[] userVal = {"0","0","0","0","0","0","0"};
        final int[] cases = {0};

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

        exaDragDefault.setOnTouchListener((view, motionEvent) -> {
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                ClipData data = ClipData.newPlainText("Default","default");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                dragged = "default";
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
                            userAlert.setTitle("If");

                            Context con = examples_Conditionals.this;
                            LinearLayout conLayout = new LinearLayout(con);
                            conLayout.setOrientation(LinearLayout.VERTICAL);

                            TextView lblSpace = new TextView(examples_Conditionals.this);
                            lblSpace.setTextSize(20);
                            conLayout.addView(lblSpace);

                            TextView lblValue = new TextView(examples_Conditionals.this);
                            lblValue.setText("Value to check: ");
                            lblValue.setTextSize(20);
                            conLayout.addView(lblValue);

                            EditText valueHolder = new EditText(con);
                            valueHolder.setHint("Variable value");
                            valueHolder.setInputType(InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_CLASS_NUMBER);
                            conLayout.addView(valueHolder);

                            TextView lblTill = new TextView(examples_Conditionals.this);
                            lblTill.setText("Check if value is greater than: ");
                            lblTill.setTextSize(20);
                            conLayout.addView(lblTill);

                            EditText ifPart = new EditText(con);
                            ifPart.setHint("if condition");
                            ifPart.setInputType(InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_CLASS_NUMBER);
                            conLayout.addView(ifPart);

                            userAlert.setView(conLayout);
                            userAlert.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    userVal[0] = valueHolder.getText().toString();
                                    userVal[1] = ifPart.getText().toString();
                                    if(userVal[0].length() != 0 && userVal[1].length() != 0) {
                                        TextView tv=new TextView(examples_Conditionals.this);
                                        tv.setTextSize(20);
                                        exaCondContainer.addView(tv);

                                        tv.setText("int x = " + userVal[0] + ";\n" + dragData.toString().concat(" (x >" + userVal[1] + ") {\n" + "\t\tSystem.out.println(\"if satisfied\");\n}"));
                                        ((ViewGroup) exaDragIf.getParent()).removeView(exaDragIf);
                                        ((ViewGroup) exaDragSwitch.getParent()).removeView(exaDragSwitch);
                                        ((ViewGroup) exaDragCase.getParent()).removeView(exaDragCase);
                                        ((ViewGroup) exaDragDefault.getParent()).removeView(exaDragDefault);
                                    }
                                }
                            });
                            userAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                            userAlert.show();

                        } else if(dragData.toString().equals("else if")){
                            if(hasIf) {
                                AlertDialog.Builder userAlert = new AlertDialog.Builder(examples_Conditionals.this);
                                userAlert.setTitle("Else if");

                                Context con = examples_Conditionals.this;
                                LinearLayout conLayout = new LinearLayout(con);
                                conLayout.setOrientation(LinearLayout.VERTICAL);

                                TextView lblSpace = new TextView(examples_Conditionals.this);
                                lblSpace.setTextSize(20);
                                conLayout.addView(lblSpace);

                                TextView lblValue = new TextView(examples_Conditionals.this);
                                lblValue.setText("Check if value is less than: ");
                                lblValue.setTextSize(20);
                                conLayout.addView(lblValue);

                                EditText elseIfPart = new EditText(con);
                                elseIfPart.setHint("else if condition");
                                elseIfPart.setInputType(InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_CLASS_NUMBER);
                                conLayout.addView(elseIfPart);


                                userAlert.setView(conLayout);
                                userAlert.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        userVal[2] = elseIfPart.getText().toString();
                                        if (userVal[2].length() != 0) {
                                            TextView tv = new TextView(examples_Conditionals.this);
                                            tv.setTextSize(20);
                                            exaCondContainer.addView(tv);
                                            tv.setText(dragData.toString().concat(" (x <" + userVal[2] + ") {\n" + "\t\tSystem.out.println(\"else if satisfied\");\n}"));
                                            ((ViewGroup) exaDragElseIf.getParent()).removeView(exaDragElseIf);
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

                        } else if(dragData.toString().equals("else")){
                            if(hasIf) {
                                hasElse = true;
                                AlertDialog.Builder userAlert = new AlertDialog.Builder(examples_Conditionals.this);
                                userAlert.setTitle("Else");

                                TextView tv = new TextView(examples_Conditionals.this);
                                tv.setText(dragData.toString().concat("{\n" + "\t\tSystem.out.println(\"else satisfied\");\n}"));
                                tv.setTextSize(20);
                                exaCondContainer.addView(tv);

                                ((ViewGroup) exaDragElse.getParent()).removeView(exaDragElse);
                            }
                        }
                        //Switches
                        else if (dragData.toString().equals("switch")) {
                            hasSwitch = true;

                            AlertDialog.Builder userAlert = new AlertDialog.Builder(examples_Conditionals.this);
                            userAlert.setTitle("Switch");

                            Context con = examples_Conditionals.this;
                            LinearLayout conLayout = new LinearLayout(con);
                            conLayout.setOrientation(LinearLayout.VERTICAL);

                            TextView lblSpace = new TextView(examples_Conditionals.this);
                            lblSpace.setTextSize(20);
                            conLayout.addView(lblSpace);

                            TextView lblValue = new TextView(examples_Conditionals.this);
                            lblValue.setText("Value to check: ");
                            lblValue.setTextSize(20);
                            conLayout.addView(lblValue);

                            EditText valueHolder = new EditText(con);
                            valueHolder.setHint("Variable value");
                            valueHolder.setInputType(InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_CLASS_NUMBER);
                            conLayout.addView(valueHolder);


                            userAlert.setView(conLayout);
                            userAlert.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    userVal[0] = valueHolder.getText().toString();
                                    if(userVal[0].length() != 0) {
                                        TextView tv=new TextView(examples_Conditionals.this);
                                        tv.setTextSize(20);
                                        exaCondContainer.addView(tv);

                                        tv.setText("int x = " + userVal[0] + ";\n" + dragData.toString().concat(" (x) {"));
                                        ((ViewGroup) exaDragSwitch.getParent()).removeView(exaDragSwitch);
                                        ((ViewGroup) exaDragIf.getParent()).removeView(exaDragIf);
                                        ((ViewGroup) exaDragElse.getParent()).removeView(exaDragElse);
                                        ((ViewGroup) exaDragElseIf.getParent()).removeView(exaDragElseIf);
                                    }
                                }
                            });
                            userAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                            userAlert.show();

                        }else if (dragData.toString().equals("case")) {
                            if(hasSwitch) {
                                cases[0]++;
                                AlertDialog.Builder userAlert = new AlertDialog.Builder(examples_Conditionals.this);
                                userAlert.setTitle("Case");


                                Context con = examples_Conditionals.this;
                                LinearLayout conLayout = new LinearLayout(con);
                                conLayout.setOrientation(LinearLayout.VERTICAL);

                                TextView lblSpace = new TextView(examples_Conditionals.this);
                                lblSpace.setTextSize(20);
                                conLayout.addView(lblSpace);

                                TextView lblValue = new TextView(examples_Conditionals.this);
                                lblValue.setText("Check if value is equal to: ");
                                lblValue.setTextSize(20);
                                conLayout.addView(lblValue);


                                EditText valueHolder = new EditText(con);
                                valueHolder.setHint("Case value");
                                valueHolder.setInputType(InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_CLASS_NUMBER);
                                conLayout.addView(valueHolder);


                                userAlert.setView(conLayout);
                                userAlert.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        if(valueHolder.getText().toString().length() != 0) {
                                            boolean cont = true;
                                            for (int i = 1; i < cases[0]; i++) {
                                                if (userVal[i].equalsIgnoreCase(valueHolder.getText().toString())) {
                                                    cases[0]--;
                                                    cont = false;
                                                }
                                            }
                                            if (cont) {
                                                TextView tv = new TextView(examples_Conditionals.this);
                                                tv.setTextSize(20);
                                                exaCondContainer.addView(tv);
                                                userVal[cases[0]] = valueHolder.getText().toString();
                                                tv.setText("\t\t" + dragData.toString().concat(" " + userVal[cases[0]] + ":\n" + "\t\t\tSystem.out.println(\"Case " + userVal[cases[0]] + " satisfied\");\n\t\t\tbreak;"));
                                            }
                                        }
                                    }
                                });
                                userAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        cases[0]--;
                                    }
                                });
                                userAlert.show();
                                if(cases[0] >= 6)
                                    ((ViewGroup) exaDragCase.getParent()).removeView(exaDragCase);
                            } else
                                Toast.makeText(examples_Conditionals.this, "Please add a switch first", Toast.LENGTH_SHORT).show();

                        }else if (dragData.toString().equals("default")) {
                            if(hasSwitch) {
                                hasDefault = true;
                                TextView tv = new TextView(examples_Conditionals.this);
                                tv.setTextSize(20);
                                exaCondContainer.addView(tv);
                                tv.setText("\t\t" + dragData.toString().concat(":\n \t\t\tSystem.out.println(\"Default satisfied\");\n" +
                                        "\t\t\tbreak;\n}"));
                                if(cases[0] < 6)
                                    ((ViewGroup) exaDragCase.getParent()).removeView(exaDragCase);
                                ((ViewGroup) exaDragDefault.getParent()).removeView(exaDragDefault);
                            } else
                                Toast.makeText(examples_Conditionals.this, "Please add a switch first", Toast.LENGTH_SHORT).show();
                        }
                        view.invalidate();
                        return true;
                    default:
                        return false;
                }
            }
        });

        exaCondButton.setOnClickListener((view) -> {
            if(hasIf) {
                if (Integer.parseInt(userVal[0]) > Integer.parseInt(userVal[1])) {
                    exaCondResult.setText("if satisfied");
                } else if (Integer.parseInt(userVal[0]) < Integer.parseInt(userVal[2])) {
                    exaCondResult.setText("else if satisfied");
                } else {
                    if(hasElse)
                        exaCondResult.setText("else satisfied");
                }
            } else if (hasSwitch){
                for(int i = 1; i < userVal.length; i++){
                    if(userVal[0].equalsIgnoreCase(userVal[i])){
                        exaCondResult.setText("case "+ userVal[i] + " satisfied");
                        break;
                    } else
                        if(hasDefault)
                            exaCondResult.setText("default satisfied");
                }
            } else
                Toast.makeText(examples_Conditionals.this, "Please add a conditional", Toast.LENGTH_SHORT).show();
        });


    }


}