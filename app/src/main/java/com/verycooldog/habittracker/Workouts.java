package com.verycooldog.habittracker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Locale;
import java.util.Objects;

public class Workouts extends AppCompatActivity implements View.OnClickListener {
    Button back_button;
    Button confirm;
    TextInputEditText weight;
    TextInputEditText met;
    TextInputEditText minutes;
    TextView burnt;
    double kcal = 0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workouts);

        burnt = findViewById(R.id.caloriesburnt);
        weight = findViewById(R.id.weight_input);
        met = findViewById(R.id.met_input);
        minutes = findViewById(R.id.minutes_input);
        back_button = findViewById(R.id.back_button);
        confirm = findViewById(R.id.confirm_workouts);
        back_button.setOnClickListener(this);
        confirm.setOnClickListener(this);
    }

    public void calcKcal() {
        double weight_val = Double.parseDouble(String.valueOf(weight.getText()));
        double met_val = Double.parseDouble(String.valueOf(met.getText()));
        int minutes_val = Integer.parseInt(String.valueOf(minutes.getText()));
        kcal += ((met_val*3.5*weight_val)/200*(double)minutes_val);
    }

    @Override
    public void onClick(View v) {

        if (v == back_button) finish();
        else if (v == confirm) {
            try {
                calcKcal();
                burnt.setText(String.format(Locale.getDefault(), "%2$,.2f %1$s", "Kcal burned", kcal));
            } catch (Exception ignored) {}
            Objects.requireNonNull(minutes.getText()).clear();
            Objects.requireNonNull(met.getText()).clear();
        }
    }
}
