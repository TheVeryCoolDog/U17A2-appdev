package com.verycooldog.habittracker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

public class Water extends AppCompatActivity implements View.OnClickListener {
    Button back_button;
    Button small_glass;
    Button medium_glass;
    Button large_glass;
    Button half_pint;
    Button pint;
    Button confirm;
    TextInputEditText input;
    TextView drank;
    Integer amount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.water);

        drank = findViewById(R.id.drank);
        input = findViewById(R.id.volume);
        back_button = findViewById(R.id.back_button);
        small_glass = findViewById(R.id.small_glass);
        medium_glass = findViewById(R.id.medium_glass);
        large_glass = findViewById(R.id.large_glass);
        half_pint = findViewById(R.id.half_pint);
        pint = findViewById(R.id.pint);
        confirm = findViewById(R.id.confirm);
        for (Button button : Arrays.asList(
                back_button, small_glass, medium_glass, large_glass, half_pint, pint, confirm)) {
            button.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        if (v == back_button) finish();
        else if (v == small_glass) amount += 220;
        else if (v == medium_glass) amount += 250;
        else if (v == large_glass) amount += 500;
        else if (v == half_pint) amount += 280;
        else if (v == pint) amount += 568;
        else if (v == confirm) {
            try {
                amount += Integer.parseInt(String.valueOf(input.getText()));
            } catch (Exception ignored) {}
            Objects.requireNonNull(input.getText()).clear();
        }
        drank.setText(String.format(Locale.getDefault(), "%dml", amount));
    }
}