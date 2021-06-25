package com.example.timerapp;

import androidx.appcompat.app.AppCompatActivity;


import android.media.MediaPlayer;
import android.os.Bundle;


import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;String secondstring; SeekBar seekBar;int time=0;


            Button button2;CountDownTimer countDownTimer;Boolean counteractive=false;

    TextView textView;


        public  void Click(View view){



                counteractive=true;
                button2.setText("Stop");
                seekBar.setEnabled(false);
             countDownTimer=new CountDownTimer(seekBar.getProgress()*1000,1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    update((int) millisUntilFinished/1000);


                }

                @Override
                public void onFinish() {

                    mediaPlayer.start();


                }
            };

            countDownTimer.start();



        }

        public void update(int getseconds){

            int minutes=getseconds/60;
            int seconds =getseconds-(minutes*60);

            if (seconds<=9){
                secondstring="0"+Integer.toString(seconds);
            }else {
                secondstring=Integer.toString(seconds);
            }
            textView.setText("0"+Integer.toString(minutes)+":"+ secondstring);}






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mediaPlayer = MediaPlayer.create(this, R.raw.alarmbeep);

            button2=findViewById(R.id.button2);

         textView=findViewById(R.id.textView3);
         seekBar =findViewById(R.id.seekBar);
        seekBar.setMax(500);
        seekBar.setProgress(30);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               update(progress);

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