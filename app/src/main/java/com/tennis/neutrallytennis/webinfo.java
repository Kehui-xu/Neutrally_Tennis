package com.tennis.neutrallytennis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class webinfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webinfo);

        WebView web = findViewById(R.id.web);
        web.loadUrl("file:///android_asset/info.htm");
    }


}