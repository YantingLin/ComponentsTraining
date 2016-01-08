package com.example.yanting_lin.broadcasttesting;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import java.io.IOException;

public class MyMusicService extends Service implements MediaPlayer.OnPreparedListener{

    private static final String TAG_THIS_ACIVITY = "MyMusicService";
    private static final String PLAY_ACTION_NAME
            = "com.example.yanting_lin.BroadcastTesting.Action.PLAY";
    MediaPlayer mMediaPlayer = null;
    public MyMusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent,int flags,int startId) {
        Log.v(TAG_THIS_ACIVITY, "onStartCommand()");
        if (intent != null) {
            if (intent.getAction() != null) {
                if (intent.getAction().equals(PLAY_ACTION_NAME)) {
                    try {
                        String url = "https://sites.google.com/site/wuyuetianzixunpingtai/"
                                + "home/ge-qu/OAOA.mp3?attredirects=0&d=1";
                        mMediaPlayer = new MediaPlayer();
                        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        mMediaPlayer.setVolume((float) 0.01, (float) 0.01);
                        mMediaPlayer.setDataSource(url);
                        mMediaPlayer.setOnPreparedListener(this);
                        mMediaPlayer.prepareAsync();
                    } catch (IOException e) {
                        Log.e(TAG_THIS_ACIVITY, "Resource not found!!!!!!!!");
                    }
                }
            }
        }
        return START_STICKY;
    }

    @Override
    public void onPrepared(MediaPlayer player){
        Log.v(TAG_THIS_ACIVITY,"onPrepared()");
        player.start();
    }
}
