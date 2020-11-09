package com.example.student.myapplication5;


import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;

public class SoundService extends Service
{
MediaPlayer player;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();//R.raw.abc
        player=MediaPlayer.create(this,Settings.System.DEFAULT_RINGTONE_URI);
        player.setLooping(true);
        player.setVolume(100,100);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       player.start();
       return START_STICKY;
    }

    @Override
    public void onDestroy()
    {
        player.stop();
        player.release();
    }
}
