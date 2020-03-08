package cn.cssf.chapter4;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

/**
 * 接收上线通知，发起任务
 */
public class The4_2_Task_Activity extends The4_2_BaseActivity {
    private final static String ACTION_STANDARD = "cn.cssf.chapter4.STANDARD";
    private final static String ACTION_TASK = "cn.cssf.chapter4.ORDER";
    private final static String ACTION_LOCAL = "cn.cssf.chapter4.LOCAL";
    private LocalBroadcastManager localBroadcastManager;
    private TaskStandardReceiver standardReceiver;
    private TaskLocalReceiver localReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the4_2_task);
        Intent intent = getIntent();
        if (intent != null && intent.getStringExtra("name")!=null){
            TextView textView = findViewById(R.id.textView1);
            textView.setText(intent.getStringExtra("name"));
        }

        //动态绑定
        IntentFilter intentFilter1 = new IntentFilter();
        intentFilter1.addAction(ACTION_STANDARD);
        standardReceiver = new TaskStandardReceiver();
        registerReceiver(standardReceiver,intentFilter1);

        //动态绑定
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction(ACTION_LOCAL);
        localReceiver = new TaskLocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver,intentFilter2);

        Button button1 = findViewById(R.id.button1),
                button2 = findViewById(R.id.button2),
                button3 = findViewById(R.id.button3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(ACTION_STANDARD);
                sendBroadcast(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(ACTION_TASK);
                sendOrderedBroadcast(intent,null);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(ACTION_LOCAL);
                localBroadcastManager.sendBroadcast(intent);
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(standardReceiver);
        localBroadcastManager.unregisterReceiver(localReceiver);
    }
}
