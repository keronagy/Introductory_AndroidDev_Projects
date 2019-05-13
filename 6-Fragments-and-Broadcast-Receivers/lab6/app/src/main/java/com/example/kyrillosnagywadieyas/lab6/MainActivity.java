package com.example.kyrillosnagywadieyas.lab6;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentA fragmentA;
    FragmentB fragmentB;
    boolean frag_a = true;
    IntentFilter intentFilter =  new IntentFilter(Intent.ACTION_TIME_TICK);

    FragmentManager fragmentManager =getFragmentManager();
    private BroadcastReceiver receiver = new BroadcastReceiver(){

        @Override
        public void onReceive(Context context, Intent intent) {

            if (frag_a){
                Toast.makeText(MainActivity.this, "fragB",Toast.LENGTH_LONG).show();

                FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container,fragmentB,"B");
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    frag_a =false;
                }
                else{
                Toast.makeText(MainActivity.this, "fraga",Toast.LENGTH_LONG).show();

                FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container,fragmentA,"A");
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    frag_a =true;
                }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        fragmentA = new FragmentA();
        fragmentB = new FragmentB();


        final FragmentManager fragmentManager =getFragmentManager();
        if (savedInstanceState==null){
            FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.container,fragmentA,"A");
            fragmentTransaction.commit();
        }else{
            fragmentA = (FragmentA) getFragmentManager().findFragmentByTag("A");
        }




    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "registered",Toast.LENGTH_LONG).show();
        this.registerReceiver(receiver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "unregistered",Toast.LENGTH_LONG).show();

        this.unregisterReceiver(receiver);
    }
}
