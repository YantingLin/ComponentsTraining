package com.example.yanting_lin.broadcasttesting;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{
    private final static String BROADCAST_ACTION_NAME
            = "com.example.yanting_lin.BroadcastTesting.YOYO_Action";

    private final static String PLAY_ACTION_NAME
            = "com.example.yanting_lin.BroadcastTesting.Action.PLAY";
    private final static String TAG_THIS_ACIVITY = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.play_button);
        button.setOnClickListener(this);



        //動態產生Broadcast Receiver
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction(BROADCAST_ACTION_NAME);
//        MyReceiverForTest myBroadcastReceiver = new MyReceiverForTest();
//        registerReceiver(myBroadcastReceiver, intentFilter);
    }
    @Override
    public void onClick(View view){
        Log.v(TAG_THIS_ACIVITY,"onClick()");
        Intent musicIntent = new Intent(this, MyMusicService.class);
        musicIntent.setAction(PLAY_ACTION_NAME);
        startService(musicIntent);
    }


}
