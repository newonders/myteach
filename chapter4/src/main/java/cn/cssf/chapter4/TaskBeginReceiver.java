package cn.cssf.chapter4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class TaskBeginReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String status = "begin";
        Log.d(this.getClass().getName(), "onReceive: " + status);
        setResultData(status);
    }
}
