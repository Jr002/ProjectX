package com.example.appdevin.projectx;

import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GameMode extends AppCompatActivity {

    TextView txtTitle,txtTimer;
    Typeface myFont;
    CountDownTimer countDownTimer;

    EditText editText;
    ListView listView;
    Button button;
    ArrayList<String> arrayList =  new ArrayList<>();;
    ArrayAdapter arrayAdapter;
    // store fruit
    String[] fruitList = {"APPLE", "ORANGE", "PEAR"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode);

        init();

        //init Font
        initFont();

        startTimer(30);

        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, arrayList);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_input = editText.getText().toString();


                for (int x = 0; x < 2; x++) {
                    if (user_input.equals(fruitList[x])) {
                        arrayList.add(user_input);
                        listView.setAdapter(arrayAdapter);
                    }else{
                        Toast.makeText(GameMode.this, "Not In the list", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });

    }

    void init(){
        txtTitle=findViewById(R.id.txtTitle);
        txtTimer=findViewById(R.id.txtTimer);
        listView = findViewById(R.id.listViewMain);

        button = findViewById(R.id.button2);
        editText = findViewById(R.id.editText);
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
