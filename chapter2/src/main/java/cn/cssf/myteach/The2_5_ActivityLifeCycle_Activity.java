package cn.cssf.myteach;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class The2_5_ActivityLifeCycle_Activity extends AppCompatActivity {

    private final String TAG = "The2_5_ActivityLifeCycle_Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the2_5__life_cycle_);
        Log.d(TAG, "onCreate...");

        Button button = findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Activity finish...");
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart...");
    }
}
