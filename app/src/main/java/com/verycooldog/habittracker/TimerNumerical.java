package com.verycooldog.habittracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TimerNumerical extends AppCompatActivity implements View.OnClickListener {
    Button back_button;
    Button change_timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer_numerical);

        back_button = findViewById(R.id.back_button);
        change_timer = findViewById(R.id.change_timer_visual);
        back_button.setOnClickListener(this);
        change_timer.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == back_button) {
            finish();
        } else if (v == change_timer) {
            finish();
            startActivity(new Intent(this, TimerVisual.class));
        }
    }
}