package com.example.neutrallytennis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CheckResult extends AppCompatActivity {

    private TextView ratio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_result);

        ratio = (TextView) findViewById(R.id.check_result2);

        Intent intent = getIntent();
        String URL = intent.getStringExtra("Ratio");
        String act_re = intent.getStringExtra("Act_Ratio");

        float ideal_result = Float.valueOf(URL);
        float act_result = Float.valueOf(act_re);

        if (ideal_result < act_result){
            ratio.setText("High");
        } else {
            ratio.setText("Low");
        }


    }
}