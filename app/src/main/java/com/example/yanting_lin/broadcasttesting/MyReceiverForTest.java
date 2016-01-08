package com.example.yanting_lin.broadcasttesting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiverForTest extends BroadcastReceiver {
    private final static String TAG_THIS_ACTIVITY = "MyReceiverForTest";
    private final static String BROADCAST_KEY = "Broadcast_key";
    private final static String BROADCAST_ACTION_NAME
            = "com.example.yanting_lin.BroadcastTesting.YOYO_Action";
    private int mNum=0;     //For testing lifecycle
    public MyReceiverForTest() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().compareTo(BROADCAST_ACTION_NAME)==0){
            String message = intent.getStringExtra(BROADCAST_KEY);
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
            Log.v(TAG_THIS_ACTIVITY, "Message is :" + message);
            Log.v(TAG_THIS_ACTIVITY, "Count :" + mNum);
            mNum++;
        }
        Log.v(TAG_THIS_ACTIVITY,"End of Receiver");
    }
}
