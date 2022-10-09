package com.example.neutrallytennis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button initial;
    private Button check;
    private TextView ratio;
    private TextView high_ratio;
    private TextView low_ratio;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initial = (Button) findViewById(R.id.initial);

        check = (Button) findViewById(R.id.check);

        ratio = (TextView) findViewById(R.id.ratio);

        high_ratio = (TextView) findViewById(R.id.high_r);

        low_ratio = (TextView) findViewById(R.id.low_r);

        result = (TextView) findViewById(R.id.result);


        Intent intent = getIntent();
        String URL = intent.getStringExtra("Ratio");
        ratio.setText(URL);

        float f=Float.parseFloat(URL);

        String high_utr = String.format("%.2f",f);
        high_ratio.setText(high_utr);

        float d=Float.parseFloat(high_utr);

        String low_utr = String.format("%.2f",(1-d));
        low_ratio.setText(low_utr);

        if ( f<0.6){
            String results = "6-4       6-4";
            result.setText(results);
        } else if (0.6<=f & f<0.63) {
            String results = "6-4       6-3";
            result.setText(results);
        } else if (0.63<=f & f<0.66) {
            String results = "6-3       6-3";
            result.setText(results);
        } else if (0.66<=f & f<0.7) {
            String results = "6-3       6-2";
            result.setText(results);
        } else if (0.70<=f & f<0.75) {
            String results = "6-2       6-2";
            result.setText(results);
        } else if (0.75<=f & f<0.8) {
            String results = "6-2       6-1";
            result.setText(results);
        } else if (0.8<=f & f<0.85) {
            String results = "6-1       6-1";
            result.setText(results);
        } else if (0.85<=f & f<0.92) {
            String results = "6-1       6-0";
            result.setText(results);
        } else {
            String results = "6-0       6-0";
            result.setText(results);
        }


        initial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Check.class);
                intent.putExtra("Ratio",URL);
                startActivity(intent);
            }
        });

    }
}