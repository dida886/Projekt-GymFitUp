package com.example.dmain.gymfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Map2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map2);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://goo.gl/YsqAf6");
    }
}
