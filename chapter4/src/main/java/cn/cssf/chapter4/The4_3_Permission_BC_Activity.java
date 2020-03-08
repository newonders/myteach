package cn.cssf.chapter4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class The4_3_Permission_BC_Activity extends AppCompatActivity {
    private final static String ACTION_PERMISSION = "cn.cssf.chapter4.permission";
    private final static String RECEIVE_PERMISSION = "cn.cssf.chapter4.permission.receive";
    private TaskPermissionReceiver permissionReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the4_3__permission__bc);

        //注册带权限广播
        permissionReceiver = new TaskPermissionReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_PERMISSION);
        registerReceiver(permissionReceiver,intentFilter);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送带权限广播
                Intent intent = new Intent();
                intent.setAction(ACTION_PERMISSION);
                sendBroadcast(intent,RECEIVE_PERMISSION);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(permissionReceiver);
    }
}
