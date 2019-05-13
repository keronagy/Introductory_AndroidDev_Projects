package com.example.koko_.lab3_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class calcText extends AppCompatActivity {
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_text);
        result = findViewById(R.id.calctxt);
        Bundle extras = getIntent().getExtras();
        if(extras != null)
            result.setText(extras.getString(MainActivity.kero));
    }
}
