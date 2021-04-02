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


    private Switch exaCondSwitch;
    private LinearLayout exaCondContainer;

    /*
    private final class MyTouchListener implements View.OnTouchListener{
        public boolean onTouch(View view, MotionEvent motionEvent){
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                Log.d("Dragging ", "this item");
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                return true;
            } else {return false;}

        }
    }*/

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

        exaCondContainer = (LinearLayout) findViewById(R.id.exaCondContainer);

        exaDragIf.setOnTouchListener((view, motionEvent) -> {
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                Log.d("Dragging ", exaDragIf.getText().toString());
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                //view.setVisibility(View.INVISIBLE);
                return true;
            } else {return false;}
        });

        exaDragElseIf.setOnTouchListener((view, motionEvent) -> {
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                Log.d("Dragging ", exaDragElseIf.getText().toString());
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                //view.setVisibility(View.INVISIBLE);
                return true;
            } else {return false;}
        });

        exaDragElse.setOnTouchListener((view, motionEvent) -> {
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                Log.d("Dragging ", exaDragElse.getText().toString());
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                //view.setVisibility(View.INVISIBLE);
                return true;
            } else {return false;}
        });


        exaDragSwitch.setOnTouchListener((view, motionEvent) -> {
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                Log.d("Dragging ", exaDragSwitch.getText().toString());
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                //view.setVisibility(View.INVISIBLE);
                return true;
            } else {return false;}
        });

        exaDragCase.setOnTouchListener((view, motionEvent) -> {
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                Log.d("Dragging ", exaDragCase.getText().toString());
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                //view.setVisibility(View.INVISIBLE);
                return true;
            } else {return false;}
        });

        exaDragBreak.setOnTouchListener((view, motionEvent) -> {
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                Log.d("Dragging ", exaDragBreak.getText().toString());
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                //view.setVisibility(View.INVISIBLE);
                return true;
            } else {return false;}
        });


        exaCondContainer.setOnDragListener(new View.OnDragListener() {
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
                        view.setBackgroundColor(Color.BLUE);
                        view.invalidate();
                        return false;
                    case DragEvent.ACTION_DRAG_EXITED:
                        view.setBackgroundColor(Color.GRAY);
                        view.invalidate();
                        return true;
                    case DragEvent.ACTION_DRAG_ENDED:
                        view.setBackgroundColor(Color.WHITE);
                        view.invalidate();
                        return true;
                    case DragEvent.ACTION_DROP:
                        ClipData.Item item = dragEvent.getClipData().getItemAt(0);
                        CharSequence dragData = item.getText();
                        Toast.makeText(examples_Conditionals.this, dragData, Toast.LENGTH_LONG).show();
                        view.setBackgroundColor(Color.WHITE);
                        view.invalidate();
                        return true;
                    default:
                        return false;
                }
            }
        });

       /* exaCondContainer.setOnDragListener(((view, dragEvent) -> {
            int action = dragEvent.getAction();
            switch(dragEvent.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    exaCondContainer.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_200));
                    break;
                case DragEvent.ACTION_DROP:
                    View v = (View) dragEvent.getLocalState();
                    ViewGroup owner = (ViewGroup) view.getParent();
                    owner.removeView(v);
                    exaCondContainer.addView(v);
                    v.setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    exaCondContainer.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
                default:
                    break;
            }
            return true;
        }));*/
    }


}