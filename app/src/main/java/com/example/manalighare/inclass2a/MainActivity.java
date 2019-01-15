//Assignment InClass02
//Team - 1. Anup Deshpande(801083424), 2. Manali Ghare(801083235)
//Group Number- 19




package com.example.manalighare.inclass2a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("BMI Calculator");


        Button calculate=(Button) findViewById(R.id.calc);
        final EditText weight=(EditText)findViewById(R.id.editText1);
        final EditText feet=(EditText)findViewById(R.id.editText2);
        final EditText inches=(EditText)findViewById(R.id.editText3);

        final TextView result=(TextView)findViewById(R.id.bmi);
        final TextView verdict=(TextView)findViewById(R.id.verdict);



        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                float w = Float.valueOf(weight.getText().toString());
                float f = Float.valueOf(feet.getText().toString());
                float i = Float.valueOf(inches.getText().toString());

                if (w < 0 || f < 0 || i < 0) {
                    result.setText(" ");
                    verdict.setText(" ");
                    Toast.makeText(MainActivity.this, "Invalid Inputs", Toast.LENGTH_LONG).show();
                } else {
                    // numbers are positive and real



                    float height = (f * 12) + i;
                    float bmi = (w / (height * height)) * 703;


                    result.setText("Your BMI : " + bmi);


                    String status;
                    if (bmi <= 18.5) {
                        status = "You are underweight";
                    } else if (bmi <= 24.9) {
                        status = "Normal Weight";
                    } else if (bmi <= 29.9) {
                        status = "You are overweight";
                    } else {
                        status = "You are obese";
                    }


                    verdict.setText(status);

                    Toast.makeText(MainActivity.this, "BMI Calculated", Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}
