package com.example.koko_.lab3_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    EditText Weight;
    EditText Height;
    Button Calc;
    double result;

    static String kero = "calcRes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calc = findViewById(R.id.calc);
        Weight = findViewById(R.id.wei);
        Height = findViewById(R.id.hei);

        Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Weight.getText().toString().equals("") || !Height.getText().toString().equals("")) {
                    double wieght = Double.parseDouble(Weight.getText().toString());
                    double height = Double.parseDouble(Height.getText().toString());
                    if (height == 0) {
                        Toast.makeText(MainActivity.this, "Please enter the right height", Toast.LENGTH_LONG).show();
                    } else {
                        try {

                            result = wieght / (height * height);

                        } catch (Exception ex) {
                            Toast.makeText(MainActivity.this, "Please enter right numbers", Toast.LENGTH_LONG).show();
                        }
                        Intent i = new Intent(MainActivity.this, calcText.class);
                        String strName = null;
                        i.putExtra(kero, result + "");
                        startActivity(i);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please put the numbers", Toast.LENGTH_LONG).show();
                }
            }});
        }


    }