package com.example.appdevin.projectx;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class splashScreen extends AppCompatActivity {

    TextView txtTitle;
    Button btnPlayGame;
    Typeface myFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        init();

        //init Font
        initFont();


    }

    void initFont(){
        myFont= Typeface.createFromAsset(this.getAssets(),"fonts/Righteous-Regular.ttf");

        txtTitle.setTypeface(myFont);
    }

    void init(){
        txtTitle=findViewById(R.id.txtTitle);

    }
}
