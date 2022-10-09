package com.example.neutrallytennis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Check extends AppCompatActivity {

    private Button initial;
    private Button prediction;
    private Button check_button;

    private EditText s1_high;
    private EditText s1_low;
    private EditText s2_high;
    private EditText s2_low;
    private EditText s3_high;
    private EditText s3_low;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        initial = (Button) findViewById(R.id.init);
        prediction = (Button) findViewById(R.id.pred);
        check_button = (Button) findViewById(R.id.check_button);

        s1_high = (EditText) findViewById(R.id.s1_high);
        s1_low = (EditText) findViewById(R.id.s1_low);
        s2_high = (EditText) findViewById(R.id.s2_high);
        s2_low = (EditText) findViewById(R.id.s2_low);
        s3_high = (EditText) findViewById(R.id.s3_high);
        s3_low = (EditText) findViewById(R.id.s3_low);

        Intent intent = getIntent();
        String URL = intent.getStringExtra("Ratio");

        check_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float s1_h = Float.parseFloat(s1_high.getText().toString());
                float s1_l = Float.parseFloat(s1_low.getText().toString());
                float s2_h = Float.parseFloat(s2_high.getText().toString());
                float s2_l = Float.parseFloat(s2_low.getText().toString());
                float s3_h = Float.parseFloat(s3_high.getText().toString());
                float s3_l = Float.parseFloat(s3_low.getText().toString());
                float h_result = s1_h + s2_h + s3_h;
                float l_result = s1_l + s2_l + s3_l;

                float ratio = h_result/(h_result + l_result);

                String ratio1 = String.valueOf(ratio);
                Intent intent = new Intent(getApplicationContext(),CheckResult.class);
                intent.putExtra("Ratio",URL);
                intent.putExtra("Act_Ratio",ratio1);
                startActivity(intent);
            }
        });

        initial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });

        prediction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });


    }
}