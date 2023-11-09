package com.tegralyn.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent i = getIntent();
        String bmi = i.getStringExtra("bmi");
        ((TextView)findViewById(R.id.result)).setText(bmi);
    }

    public void BackButton(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}