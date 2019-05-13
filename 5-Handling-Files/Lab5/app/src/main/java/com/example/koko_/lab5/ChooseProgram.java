package com.example.koko_.lab5;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ChooseProgram extends AppCompatActivity {
    TextView ProName;
    String ProgramName;
    String id;
    ListView lv;
    ImageButton btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_program);
        Bundle extras = getIntent().getExtras();
        ProName = findViewById(R.id.proName);
        lv = findViewById(R.id.lv1);
        btn = findViewById(R.id.ib);
        if (extras != null) {
            ProgramName = extras.getString(MainActivity.PROGRAM);
            id = extras.getString(MainActivity.ID);
            SpannableString str = new SpannableString(ProgramName);
            str.setSpan(new BackgroundColorSpan(Color.CYAN), 0, ProgramName.length(), 0);
            ProName.setText(str);
            try {
                BufferedReader bReader = new BufferedReader(new InputStreamReader(getAssets().open(id + ".txt")));
                ArrayList<String> values = new ArrayList<String>();
                String line = bReader.readLine();
                while (line != null) {
                    values.add(line);
                    line = bReader.readLine();
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, values);
                lv.setAdapter(adapter);
                bReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChooseProgram.this, ASU_Logo.class);
                startActivity(i);
            }
        });
    }
}
