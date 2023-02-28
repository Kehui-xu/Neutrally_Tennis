package com.tennis.neutrallytennis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


public class Login extends AppCompatActivity {
    private EditText high;
    private EditText low;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        high = findViewById(R.id.high_utr);

        low = findViewById(R.id.low_utr);

        Button logB = findViewById(R.id.logB);

        logB.setOnClickListener(view -> {
            float high_utr;
            if(high.getText().toString().equals("")){
                high_utr = 0;
            }else {
                high_utr = Float.parseFloat(high.getText().toString());
            }
            float low_utr;
            if(low.getText().toString().equals("")){
                low_utr = 0;
            }else {
                low_utr = Float.parseFloat(low.getText().toString());
            }

            float cof = (float)0.1907269;
            float inter = (float)0.5;

            float ratio = cof*(high_utr - low_utr) + inter;

            String ratio1 = String.valueOf(ratio);
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            intent.putExtra("Ratio",ratio1);
            startActivity(intent);
        });
    }


}