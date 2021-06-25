package com.example.timerapp;

import androidx.appcompat.app.AppCompatActivity;


import android.media.MediaPlayer;
import android.os.Bundle;


import android.os.CountDownTimer;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;String secondstring;
// no need to call prepare(); create() does that for you

    TextView textView;int time=10000;

    CountDownTimer countDownTimer=new CountDownTimer(Integer.parseInt(secondstring),1000) {
        @Override
        public void onTick(long millisUntilFinished) {

                textView.setText(String.valueOf(time));time--;
        }

        @Override
        public void onFinish() {

                mediaPlayer.start();
        }
    };

        public  void Click(View view){
            countDownTimer.start();


        }







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mediaPlayer = MediaPlayer.create(this, R.raw.alarmbeep);

         textView=findViewById(R.id.textView3);
        SeekBar seekBar =findViewById(R.id.seekBar);
        seekBar.setMax(500);
        seekBar.setProgress(30);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int minutes=progress/60;
                int seconds =progress-(minutes*60);

                if (seconds<=9){
                    secondstring="0"+Integer.toString(seconds);
                }else {
                    secondstring=Integer.toString(seconds);
                }
                textView.setText("0"+Integer.toString(minutes)+":"+ secondstring);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
}