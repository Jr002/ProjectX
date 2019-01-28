package com.example.appdevin.projectx;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class mainMenu extends AppCompatActivity {
    Button btnPlayGame,btnSetting,btnCredits,btnGamesPlayed;
    TextView txtTitle;
    Typeface myFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        init();

        //Init the fonts
        initFont();


    }

    void initFont(){
        myFont= Typeface.createFromAsset(this.getAssets(),"fonts/Righteous-Regular.ttf");
        btnPlayGame.setTypeface(myFont);
        btnSetting.setTypeface(myFont);
        btnCredits.setTypeface(myFont);
        btnGamesPlayed.setTypeface(myFont);

       txtTitle.setTypeface(myFont);
    }

    void init(){
        btnPlayGame=findViewById(R.id.btnPlayGame);
        btnCredits=findViewById(R.id.btnCredits);
        btnSetting=findViewById(R.id.btnSettings);
        btnGamesPlayed=findViewById(R.id.btnGamesPlayed);

        txtTitle=findViewById(R.id.nameTitle);


    }
}
