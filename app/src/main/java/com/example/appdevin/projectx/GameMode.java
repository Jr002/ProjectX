package com.example.appdevin.projectx;

import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameMode extends AppCompatActivity {

    TextView txtTitle,txtTimer;
    Typeface myFont;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode);

        init();

        //init Font
        initFont();

        startTimer(30);
    }

    void init(){
        txtTitle=findViewById(R.id.txtTitle);
        txtTimer=findViewById(R.id.txtTimer);

    }

    void initFont(){
        myFont= Typeface.createFromAsset(this.getAssets(),"fonts/Righteous-Regular.ttf");

        txtTitle.setTypeface(myFont);
        txtTimer.setTypeface(myFont);
    }

    //To start the timer

    /*
    To start the timer to let the
    player know that there is time limit
    before skiping their turn*/

    void startTimer(int time){
        txtTimer.setText(String.valueOf(time));

        countDownTimer = new CountDownTimer(time * 1000, 1000){

            @Override
            public void onTick(long l) {
                txtTimer.setText(""+l/1000);
            }

            @Override
            public void onFinish() {
                Toast.makeText(GameMode.this,"Done!!",Toast.LENGTH_SHORT).show();
            }
        };

        countDownTimer.start();

    }

    //To stop the timer
    void stopTimer(){
        countDownTimer.cancel();
        countDownTimer=null;
    }

}
