package com.example.koko_.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button Start;
    Button Stop;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Start = findViewById(R.id.Start);
        Stop = findViewById(R.id.Stop);
        i  = new Intent(MainActivity.this, myService.class);
        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(i);
                Toast.makeText(MainActivity.this, "Service Started",
                        Toast.LENGTH_LONG).show();
            }
        });

        Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(i);
                Toast.makeText(MainActivity.this, "Service Stopped",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

}
