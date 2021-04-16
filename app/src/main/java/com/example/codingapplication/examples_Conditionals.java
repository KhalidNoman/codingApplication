package com.example.codingapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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
                            TextView tv=new TextView(examples_Conditionals.this);
                            tv.setText(dragData.toString().concat(" () {"));
                            tv.setTextSize(30);
                            exaCondContainer.addView(tv);

                            ((ViewGroup) exaDragSwitch.getParent()).removeView(exaDragSwitch);
                            ((ViewGroup) exaDragCase.getParent()).removeView(exaDragCase);
                            ((ViewGroup) exaDragBreak.getParent()).removeView(exaDragBreak);
                        } else if(dragData.toString().equals("else if")){

                        } else if(dragData.toString().equals("else")){

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


    }


}