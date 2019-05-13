package com.cse437.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button cairoBtn;
    private Button alexBtn;
    private Button aswanBtn;
    private TextView tv_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cairoBtn = findViewById(R.id.cairo);
        alexBtn = findViewById(R.id.alex);
        aswanBtn = findViewById(R.id.aswan);
        tv_text = findViewById(R.id.tv_text);

        cairoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(v,getString(R.string.CAIROTXT));
            }
        });
        alexBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(v,getString(R.string.ALEXTXT));
            }
        });
        aswanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(v,getString(R.string.ASWANTXT));
            }
        });
    }
    public void save(View view, String txt){
        tv_text.setText(txt);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("textView_Text",tv_text.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String value = savedInstanceState.getString("textView_Text");
        tv_text.setText(value);
    }
}
