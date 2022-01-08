package com.usman.learningtests;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.usman.learningtests.Activities.Age;
import com.usman.learningtests.Activities.Arthm;
import com.usman.learningtests.Activities.Bmi;
import com.usman.learningtests.Activities.Currency;
import com.usman.learningtests.Activities.Stopwatch;
import com.usman.learningtests.Activities.Tempc;


public class MainActivity extends AppCompatActivity {

    GridLayout gridLayout;
    CardView bmi, age, arthm, tempc, stopwatch, currency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        gridLayout=(GridLayout)findViewById(R.id.mainGrid);
        bmi = findViewById(R.id.bmi);
        age = findViewById(R.id.age);
        arthm = findViewById(R.id.arthm);
        tempc = findViewById(R.id.tempc);
        stopwatch = findViewById(R.id.stopwatch);
        currency = findViewById(R.id.currency);

        setSingleEvent(gridLayout);


        // to BMI Activity
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(this,BMI.class);

                Intent intent = new Intent(getApplicationContext(), Bmi.class);
                startActivity(intent);
            }
        });


        // to age Activity
        age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(this,BMI.class);

                Intent intent = new Intent(getApplicationContext(), Age.class);
                startActivity(intent);
            }
        });


        // to arthm Activity
        arthm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(this,BMI.class);

                Intent intent = new Intent(getApplicationContext(), Arthm.class);
                startActivity(intent);
            }
        });


        // to tempc Activity
        tempc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(this,BMI.class);

                Intent intent = new Intent(getApplicationContext(), Tempc.class);
                startActivity(intent);
            }
        });



        // to stopwatch Activity
        stopwatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(this,BMI.class);

                Intent intent = new Intent(getApplicationContext(), Stopwatch.class);
                startActivity(intent);
            }
        });



        // to currency Activity
        currency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(this,BMI.class);

                Intent intent = new Intent(getApplicationContext(), Currency.class);
                startActivity(intent);
            }
        });



    }




    // we are setting onClickListener for each element
    private void setSingleEvent(GridLayout gridLayout) {
        for(int i = 0; i<gridLayout.getChildCount();i++){
            CardView cardView=(CardView)gridLayout.getChildAt(i);
            final int finalI= i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this,"Clicked at index "+ finalI,
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


}