package com.tennis.neutrallytennis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Check extends AppCompatActivity {

    private EditText s1_high;
    private EditText s1_low;
    private EditText s2_high;
    private EditText s2_low;
    private EditText s3_high;
    private EditText s3_low;
    private EditText mtb_high;
    private EditText mtb_low;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        Button initial = findViewById(R.id.init);
        Button check_button = findViewById(R.id.check_button);

        s1_high = findViewById(R.id.s1_high);
        s1_low = findViewById(R.id.s1_low);
        s2_high = findViewById(R.id.s2_high);
        s2_low = findViewById(R.id.s2_low);
        s3_high = findViewById(R.id.s3_high);
        s3_low = findViewById(R.id.s3_low);
        mtb_high = findViewById(R.id.mtb_high);
        mtb_low = findViewById(R.id.mtb_low);

        Intent intent = getIntent();
        String URL = intent.getStringExtra("Ratio");

        check_button.setOnClickListener(view -> {
            float s1_h;
            if(s1_high.getText().toString().equals("")){
                s1_h = 0;
            }else{
                s1_h = Float.parseFloat(s1_high.getText().toString());
            }
            float s1_l;
            if(s1_low.getText().toString().equals("")){
                s1_l = 0;
            }else{
                s1_l = Float.parseFloat(s1_low.getText().toString());
            }
            float s2_h;
            if(s2_high.getText().toString().equals("")){
                s2_h = 0;
            }else{
                s2_h = Float.parseFloat(s2_high.getText().toString());
            }
            float s2_l;
            if(s2_low.getText().toString().equals("")){
                s2_l = 0;
            }else{
                s2_l = Float.parseFloat(s2_low.getText().toString());
            }
            float s3_h;
            if(s3_high.getText().toString().equals("")){
                s3_h = 0;
            }else{
                s3_h = Float.parseFloat(s3_high.getText().toString());
            }
            float s3_l;
            if(s3_low.getText().toString().equals("")){
                s3_l = 0;
            }else{
                s3_l = Float.parseFloat(s3_low.getText().toString());
            }
            float mtb_h;
            if(mtb_high.getText().toString().equals("")){
                mtb_h = 0;
            }else{
                mtb_h = Float.parseFloat(mtb_high.getText().toString());
            }
            float mtb_l;
            if(mtb_low.getText().toString().equals("")){
                mtb_l = 0;
            }else {
                mtb_l = Float.parseFloat(mtb_low.getText().toString());
            }
            float mtb_hr;
            float mtb_lr;
            if (mtb_h > mtb_l){
                mtb_hr = 2;
                mtb_lr = 0;
            } else if (mtb_h < mtb_l){
                mtb_hr = 0;
                mtb_lr = 2;
            } else {
                mtb_hr = 0;
                mtb_lr = 0;
            }
            float h_result = s1_h + s2_h + s3_h + mtb_hr;
            float l_result = s1_l + s2_l + s3_l + mtb_lr;

            float ratio = h_result/(h_result + l_result);

            String ratio1 = String.valueOf(ratio);
            Intent intent1 = new Intent(getApplicationContext(),CheckResult.class);
            intent1.putExtra("Ratio",URL);
            intent1.putExtra("Act_Ratio",ratio1);
            startActivity(intent1);
        });

        initial.setOnClickListener(view -> {
            Intent intent12 = new Intent(getApplicationContext(),Login.class);
            startActivity(intent12);
        });

    }
}