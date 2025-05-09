package com.verycooldog.habittracker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Workouts extends AppCompatActivity implements View.OnClickListener {
    Button back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workouts);

        back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        finish();
    }
}