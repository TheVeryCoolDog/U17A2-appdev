package com.verycooldog.habittracker;

import static java.lang.Math.floor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class TimerNumerical extends AppCompatActivity implements View.OnClickListener {
    Button back_button;
    Button change_timer;
    Button timer_toggle;
    Button lap_clear;
    TextView timer_txt;
    Boolean pause = true;
    double count = 0.0;
    LinearLayout laps_done;
    ScrollView laps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer_numerical);

        timer_txt = findViewById(R.id.timer_text);
        back_button = findViewById(R.id.back_button);
        change_timer = findViewById(R.id.change_timer_visual);
        timer_toggle = findViewById(R.id.timer_toggle);
        lap_clear = findViewById(R.id.lap_clear);
        for (Button button : Arrays.asList(back_button, change_timer, timer_toggle, lap_clear)) {
            button.setOnClickListener(this);
        }
        start_timer();
        laps_done = findViewById(R.id.laps_done);
        laps = findViewById(R.id.laps);
    }

    public void start_timer() {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    if (!pause) {
                        count += 0.01;
                        timer_txt.setText(String.format(Locale.getDefault(),
                                "%1$02.0f:%2$05.2f", floor(count/60)%60, count%60));
                    }
                });
            }
        }, 0, 10);
    }

    @Override
    public void onClick(View v) {
        if (v == back_button) finish();
        else if (v == change_timer) {
            finish();
            startActivity(new Intent(this, TimerVisual.class));
        } else if (v == timer_toggle) {
            if (pause) {
                timer_toggle.setText(R.string.timer_toggle_stop);
                lap_clear.setText(R.string.timer_toggle_lap);
            } else {
                timer_toggle.setText(R.string.timer_toggle_start);
                lap_clear.setText(R.string.timer_toggle_clear);
            }
            pause = !pause;
        } else if (v == lap_clear) {
            if (pause) {
                count = 0.0;
                timer_txt.setText(R.string.timer_default);
                laps_done.removeAllViews();
                laps.setVisibility(View.INVISIBLE);
            } else {
                laps.setVisibility(View.VISIBLE);
                TextView placeholder = new TextView(this);
                placeholder.setText(String.format(Locale.getDefault(),
                        "%1$02.0f:%2$05.2f",
                        floor(count/60)%60, count%60));
                laps_done.addView(placeholder);
            }
        }
    }
}