package com.tennis.neutrallytennis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button initial = findViewById(R.id.initial);

        Button check = findViewById(R.id.check);

        TextView ratio = findViewById(R.id.ratio);

        TextView high_ratio = findViewById(R.id.high_r);

        TextView low_ratio = findViewById(R.id.low_r);

        TextView high_result = findViewById(R.id.high_result);

        TextView low_result = findViewById(R.id.low_result);


        Intent intent = getIntent();
        String URL = intent.getStringExtra("Ratio");
        ratio.setText(URL);

        float f = Float.parseFloat(URL);
        float d = 1-f;

        BigDecimal b = new BigDecimal(f);
        double f1 = b.setScale(2, BigDecimal.ROUND_UP).doubleValue();
        DecimalFormat df = new DecimalFormat("#%");

        String high_utr = df.format(f1);
        high_ratio.setText(high_utr);

        BigDecimal c = new BigDecimal(d);
        double f2 = c.setScale(2, BigDecimal.ROUND_UP).doubleValue();

        String low_utr = df.format(f2);
        low_ratio.setText(low_utr);

        if ( f<0.6){
            String results = "6-4       6-4";
            high_result.setText(results);
        } else if (0.6<=f & f<0.63) {
            String results = "6-4       6-3";
            high_result.setText(results);
        } else if (0.63<=f & f<0.66) {
            String results = "6-3       6-3";
            high_result.setText(results);
        } else if (0.66<=f & f<0.7) {
            String results = "6-3       6-2";
            high_result.setText(results);
        } else if (0.70<=f & f<0.75) {
            String results = "6-2       6-2";
            high_result.setText(results);
        } else if (0.75<=f & f<0.8) {
            String results = "6-2       6-1";
            high_result.setText(results);
        } else if (0.8<=f & f<0.85) {
            String results = "6-1       6-1";
            high_result.setText(results);
        } else if (0.85<=f & f<0.92) {
            String results = "6-1       6-0";
            high_result.setText(results);
        } else {
            String results = "6-0       6-0";
            high_result.setText(results);
        }

        if ( 0.36<=d){
            String results = "4-6       4-6";
            low_result.setText(results);
        } else if (0.33<=d & d<0.36) {
            String results = "4-6       3-6";
            low_result.setText(results);
        } else if (0.29<=d & d<0.33) {
            String results = "3-6       3-6";
            low_result.setText(results);
        } else if (0.25<=d & d<0.29) {
            String results = "3-6       2-6";
            low_result.setText(results);
        } else if (0.2<=d & d<0.25) {
            String results = "2-6       2-6";
            low_result.setText(results);
        } else if (0.14<=d & d<0.2) {
            String results = "2-6       1-6";
            low_result.setText(results);
        } else if (0.08<=d & d<0.14) {
            String results = "1-6       1-6";
            low_result.setText(results);
        } else {
            String results = "1-6       0-6";
            low_result.setText(results);
        }


        initial.setOnClickListener(view -> {
            Intent intent1 = new Intent(getApplicationContext(),Login.class);
            startActivity(intent1);
        });

        check.setOnClickListener(view -> {
            Intent intent12 = new Intent(getApplicationContext(),Check.class);
            intent12.putExtra("Ratio",URL);
            startActivity(intent12);
        });

    }
}