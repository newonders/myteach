package cn.cssf.chapter4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class The4_2_BaseActivity extends AppCompatActivity {

    protected final static String LOGIN = "已登录";
    protected final static String LOGOUT = "未登录";
    protected final static String ACTION_OFFLINE = "com.cssf.chapter4.OFFLINE";
    protected static List<Activity> activityCollect;
    protected OffLineReceiver offLineReceiver;
    protected static boolean isLogin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCollect = new ArrayList();
        if (!activityCollect.contains(this))
            activityCollect.add(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_OFFLINE);
        offLineReceiver = new OffLineReceiver();
        registerReceiver(offLineReceiver,intentFilter);
    }

    protected void clearAll(){
        for (Activity activity : activityCollect)
            activity.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(offLineReceiver);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.base_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String str = item.getTitle().toString();
        if (str.contains(LOGIN)){
            Intent intent = new Intent();
            intent.setAction(ACTION_OFFLINE);
            sendBroadcast(intent);
        }
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem item = menu.getItem(0);
        if (!isLogin)
            item.setTitle(LOGOUT);
        else item.setTitle(LOGIN);
        return true;
    }

    class OffLineReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(final Context context, Intent intent) {
            clearAll(); //消毁所有Activity
            isLogin = false; //设置未登录状态
            Intent intent1 = new Intent(context,The4_2_Login_BC_Activity.class);
            context.startActivity(intent1);

        }
    }
}
