package com.example.koko_.lab4;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class myService extends Service {
    MediaPlayer ring;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        ring.stop();
        super.onDestroy();
    }

    @Override
    public void onCreate() {
        ring = MediaPlayer.create(this,R.raw.milk);
        ring.start();
        super.onCreate();
    }
}

