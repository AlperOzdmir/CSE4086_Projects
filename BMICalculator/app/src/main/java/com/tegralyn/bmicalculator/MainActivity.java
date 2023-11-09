package com.tegralyn.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CalculateBMI(View v){
        String heightInput = ((EditText)findViewById(R.id.heightInput)).getText().toString();
        String weightInput = ((EditText)findViewById(R.id.weightInput)).getText().toString();
        if ( heightInput.matches("") || weightInput.matches("")) {
            findViewById(R.id.errorText).setVisibility(View.VISIBLE);
        }
        else {
            double weight = Double.parseDouble(weightInput);
            double height = (Double.parseDouble(heightInput) / 100.0);
            if (weight <= 0 || height <= 0 || weight >= 200 || height >= 3.0) {
                findViewById(R.id.errorText).setVisibility(View.VISIBLE);
                return;
            }
            String bmi = String.format("%.1f",(weight / (height * height)));
            Intent i = new Intent(this, ResultActivity.class);
            i.putExtra("bmi", bmi);
            startActivity(i);
        }
    }
}