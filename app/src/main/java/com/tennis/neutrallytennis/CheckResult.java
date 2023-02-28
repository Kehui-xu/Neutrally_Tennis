package com.tennis.neutrallytennis;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CheckResult extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_result);

        TextView ratio = findViewById(R.id.check_result2);
        Button back = findViewById(R.id.back);

        Intent intent = getIntent();
        String URL = intent.getStringExtra("Ratio");
        String act_re = intent.getStringExtra("Act_Ratio");

        float ideal_result = Float.parseFloat(URL);
        float act_result = Float.parseFloat(act_re);

        if (ideal_result < act_result){
            ratio.setText("High");
        } else {
            ratio.setText("Low");
        }

        back.setOnClickListener(view -> {
            Intent intent1 = new Intent(getApplicationContext(),Login.class);
            startActivity(intent1);
        });
    }
}