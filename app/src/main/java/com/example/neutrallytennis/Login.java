package com.example.neutrallytennis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Login extends AppCompatActivity {
    private EditText high;
    private EditText low;
    private Button logB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        high = (EditText) findViewById(R.id.high_utr);

        low = (EditText) findViewById(R.id.low_utr);

        logB = (Button) findViewById(R.id.logB);

        logB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float high_utr = Float.parseFloat(high.getText().toString());
                float low_utr = Float.parseFloat(low.getText().toString());

                float cof = (float)0.14822229;
                float inter = (float)0.51602479;

                float ratio = cof*(high_utr - low_utr) + inter;

                String ratio1 = String.valueOf(ratio);
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("Ratio",ratio1);
                startActivity(intent);
            }
        });
    }


}