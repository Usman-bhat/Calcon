package com.usman.learningtests.Activities;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

// importing required classes
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.usman.learningtests.R;

import java.util.Locale;

public class Stopwatch extends AppCompatActivity {

    // integers to store hours , minutes , seconds ,  ms
    int hours, minutes, secs, ms;

    // integer to store seconds
    private int seconds = 0;

    // boolean to check if stopwatch is running or not
    private boolean running;

    // simple count variable to count number of laps
    int lapCount = 0;

    // creating object of ImageView and Text View
    ImageView playBtn, pauseBtn, stopBtn, timeLapseBtn;
    TextView timeView;
    TextView timeViewms;
    TextView timeLapse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        //back buttom
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // initializing the Image view objects
        playBtn = (ImageView) findViewById(R.id.playBtn);
        pauseBtn = (ImageView) findViewById(R.id.pauseBtn);
        stopBtn = (ImageView) findViewById(R.id.stopBtn);
        timeLapseBtn = (ImageView) findViewById(R.id.timeLapseBtn);

        // initializing the text view objects
        timeView = (TextView) findViewById(R.id.time_view);
        timeViewms = (TextView) findViewById(R.id.time_view_ms);
        timeLapse = (TextView) findViewById(R.id.timeLapse);

        // play button click listener
        playBtn.setOnClickListener(new View.OnClickListener() {@Override
        public void onClick(View view) {

            //showing simple toast message to user
            Toast.makeText(Stopwatch.this, "Started", Toast.LENGTH_SHORT).show();

            // hide the play and stop button
            playBtn.setVisibility(View.GONE);
            stopBtn.setVisibility(View.GONE);

            // show the pause  and time lapse button
            pauseBtn.setVisibility(View.VISIBLE);
            timeLapseBtn.setVisibility(View.VISIBLE);

            // set running true
            running = true;
        }
        });
        // pause button click listener
        pauseBtn.setOnClickListener(new View.OnClickListener() {@Override
        public void onClick(View view) {

            //showing simple toast message to user
            Toast.makeText(Stopwatch.this, "Paused", Toast.LENGTH_SHORT).show();

            // show the play  and stop  button
            playBtn.setVisibility(View.VISIBLE);
            stopBtn.setVisibility(View.VISIBLE);

            // hide the pause  and time lapse button
            timeLapseBtn.setVisibility(View.GONE);
            pauseBtn.setVisibility(View.GONE);

            running = false;
        }
        });

        // stop  button click listener
        stopBtn.setOnClickListener(new View.OnClickListener() {@Override
        public void onClick(View view) {

            //showing simple toast message to user
            Toast.makeText(Stopwatch.this, "Stoped", Toast.LENGTH_SHORT).show();

            // set running to false
            running = false;
            seconds = 0;
            lapCount = 0;

            // setting the text view to zero
            timeView.setText("00:00:00");
            timeViewms.setText("00");
            timeLapse.setText("");

            // show the play
            playBtn.setVisibility(View.VISIBLE);

            // hide the pause , stop and time lapse button
            pauseBtn.setVisibility(View.GONE);
            stopBtn.setVisibility(View.GONE);
            timeLapseBtn.setVisibility(View.GONE);

        }
        });

        // lap button click listener
        timeLapseBtn.setOnClickListener(new View.OnClickListener() {@Override
        public void onClick(View view) {
            // calling timeLapse function
            timeLapseFun();
        }
        });

        // calling runtimer
        runTimer();

    }

    //for back button
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void runTimer() {

        // creating handler
        final Handler handlertime = new Handler();

        // creating handler
        final Handler handlerMs = new Handler();

        handlertime.post(new Runnable() {@Override

        public void run() {
            hours = seconds / 3600;
            minutes = (seconds % 3600) / 60;
            secs = seconds % 60;

            // if running increment the seconds
            if (running) {
                String time = String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, secs);

                timeView.setText(time);

                seconds++;
            }

            handlertime.postDelayed(this, 1000);
        }
        });

        handlerMs.post(new Runnable() {@Override
        public void run() {

            if (ms >= 99) {
                ms = 0;
            }

            // if running increment the ms
            if (running) {
                String msString = String.format(Locale.getDefault(), "%02d", ms);
                timeViewms.setText(msString);

                ms++;
            }
            handlerMs.postDelayed(this, 1);
        }
        });

    }

    void timeLapseFun() {

        // increase lap count when function is called
        lapCount++;

        String laptext = String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, secs);
        String msString = String.format(Locale.getDefault(), "%02d", ms);

        // adding ms to lap text
        laptext = laptext + ":" + msString;

        if (lapCount >= 10) {
            laptext = " Lap " + lapCount + " --------------->       " + laptext + " \n " + timeLapse.getText();
        } else {
            laptext = " Lap " + lapCount + " --------------->       " + laptext + " \n " + timeLapse.getText();

        }

        //showing simple toast message to user
        Toast.makeText(Stopwatch.this, "Lap " + lapCount, Toast.LENGTH_SHORT).show();

        // showing the lap text
        timeLapse.setText(laptext);
    }
}




