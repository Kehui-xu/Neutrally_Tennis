package com.tennis.neutrallytennis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button info = findViewById(R.id.info);
        Button app = findViewById(R.id.app);

        info.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),webinfo.class);
            startActivity(intent);
        });

        app.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),Login.class);
            startActivity(intent);
        });
    }
}