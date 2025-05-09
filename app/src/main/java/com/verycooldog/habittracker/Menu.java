package com.verycooldog.habittracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class Menu extends AppCompatActivity implements View.OnClickListener {

    Button water;
    Button timer;
    Button workout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.menu);

        water = findViewById(R.id.water);
        timer = findViewById(R.id.timer);
        workout = findViewById(R.id.workouts);
        water.setOnClickListener(this);
        timer.setOnClickListener(this);
        workout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == water){
            startActivity(new Intent(this, Water.class));
        } else if (v == timer) {
            startActivity(new Intent(this, TimerNumerical.class));
        } else if (v == workout) {
            startActivity(new Intent(this, Workouts.class));
        }
    }
}