package com.usman.learningtests.Activities;

import static com.usman.learningtests.Activities.Helpers.BMICalcUtil.BMI_CATEGORY_HEALTHY;
import static com.usman.learningtests.Activities.Helpers.BMICalcUtil.BMI_CATEGORY_OBESE;
import static com.usman.learningtests.Activities.Helpers.BMICalcUtil.BMI_CATEGORY_OVERWEIGHT;
import static com.usman.learningtests.Activities.Helpers.BMICalcUtil.BMI_CATEGORY_UNDERWEIGHT;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.usman.learningtests.Activities.Helpers.BMICalcUtil;
import com.usman.learningtests.R;

public class Tempc extends AppCompatActivity {

    Button convert;
    TextView temperature_result;
    EditText temperature_to_convert;
    ToggleButton toggleButton;
    Double a;
    private CardView tempResultCardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempc);
        //back buttom
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);



        temperature_to_convert=(EditText) findViewById(R.id.temperature_to_convert);
        convert=(Button) findViewById(R.id.temperature_converter_btn);
        toggleButton=(ToggleButton) findViewById(R.id.togglecelfar);
        temperature_result=(TextView) findViewById(R.id.temperature_result);
        tempResultCardView = findViewById(R.id.tempResultCardView);


        tempResultCardView.setVisibility(View.GONE);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(temperature_to_convert.getText().toString().isEmpty())
                {
                    Toast.makeText(Tempc.this,"Please enter the temperature",Toast.LENGTH_SHORT).show();
                }

                else if(toggleButton.isChecked())
                {
                    a=Double.parseDouble(String.valueOf(temperature_to_convert.getText()));
                    Double b=a*9/5+32;
                    String r=String.valueOf(b);
                    displayTEMP(r,true);
                    Toast.makeText(Tempc.this,r+"°F",Toast.LENGTH_SHORT).show();
                }

                else
                {
                    a=Double.parseDouble(String.valueOf(temperature_to_convert.getText()));
                    Double b=a-32;
                    Double c=b*5/9;
                    String r=String.valueOf(c);
                    displayTEMP(r,false);
                    Toast.makeText(Tempc.this,r+"°C",Toast.LENGTH_SHORT).show();
                }
            }
        });

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

    private void displayTEMP(String temp,boolean type) {
        tempResultCardView.setVisibility(View.VISIBLE);

        if (type) {
            temperature_result.setText(temp+" °F");
        }
        else{
            temperature_result.setText(temp+ " °C");

        }
    }
}