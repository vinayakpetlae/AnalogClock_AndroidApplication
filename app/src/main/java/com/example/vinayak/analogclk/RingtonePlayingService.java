package com.example.vinayak.analogclk;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.util.Random;

public class RingtonePlayingService extends Service {

    private boolean isRunning;
    private Context context;
    MediaPlayer mMediaPlayer;
    private int startId;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        final NotificationManager mNM = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);

        Intent intent1 = new Intent(this.getApplicationContext(), Alarm.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent1, 0);

        Notification mNotify = new Notification.Builder(this)
                .setContentTitle("Alarm! Its Time Up" + "!")
                .setContentText("Click me!")
                .setSmallIcon(R.mipmap.clok)
                .setContentIntent(pIntent)
                .setAutoCancel(true)
                .build();

        String state = intent.getExtras().getString("extra");


        assert state != null;
        switch (state) {
            case "no":
                startId = 0;
                break;
            case "yes":
                startId = 1;
                break;
            default:
                startId = 0;
                break;
        }


        if (!this.isRunning && startId == 1) {
            int min = 1;
            int max = 9;

            Random r = new Random();
            int random_number = r.nextInt(max - min + 1) + min;

            if (random_number == 1) {
                mMediaPlayer = MediaPlayer.create(this, R.raw.tone);
            } else if (random_number == 2) {
                mMediaPlayer = MediaPlayer.create(this, R.raw.tone);
            } else if (random_number == 3) {
                mMediaPlayer = MediaPlayer.create(this, R.raw.tone);
            } else if (random_number == 4) {
                mMediaPlayer = MediaPlayer.create(this, R.raw.tone);
            } else if (random_number == 5) {
                mMediaPlayer = MediaPlayer.create(this, R.raw.tone);
            } else if (random_number == 6) {
                mMediaPlayer = MediaPlayer.create(this, R.raw.tone);
            } else if (random_number == 7) {
                mMediaPlayer = MediaPlayer.create(this, R.raw.tone);
            } else if (random_number == 8) {
                mMediaPlayer = MediaPlayer.create(this, R.raw.tone);
            } else if (random_number == 9) {
                mMediaPlayer = MediaPlayer.create(this, R.raw.tone);
            } else {
                mMediaPlayer = MediaPlayer.create(this, R.raw.tone);
            }

            mMediaPlayer.start();


            mNM.notify(0, mNotify);

            this.isRunning = true;
            this.startId = 0;

        } else if (!this.isRunning && startId == 0) {

            this.isRunning = false;
            this.startId = 0;

        } else if (this.isRunning && startId == 1) {

            this.isRunning = true;
            this.startId = 0;

        } else {

            mMediaPlayer.stop();
            mMediaPlayer.reset();

            this.isRunning = false;
            this.startId = 0;
        }

        return START_NOT_STICKY;

    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        this.isRunning = false;
    }


}
