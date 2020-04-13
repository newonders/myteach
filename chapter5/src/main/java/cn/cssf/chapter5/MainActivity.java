package cn.cssf.chapter5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.button1),
                button2 = findViewById(R.id.button2),
                button3 = findViewById(R.id.button3),
                button4 = findViewById(R.id.button4),
                button5 = findViewById(R.id.button5),
                button6 = findViewById(R.id.button6),
                button7 = findViewById(R.id.button7),
                button8 = findViewById(R.id.button8),
                button9 = findViewById(R.id.button9),
                button10 = findViewById(R.id.button10);
        MyOnClickListener listener = new MyOnClickListener(MainActivity.this);
        button1.setText("本地文件读写");
        button2.setText("SharedPreferences读写");
        button3.setText("SQLite读写");
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        button10.setOnClickListener(listener);

    }

    private class MyOnClickListener implements View.OnClickListener{
        Context context;
        MyOnClickListener(Context context){
            this.context = context;
        }
        @Override
        public void onClick(View view) {
            Intent intent = null;
            int id = view.getId();
            switch (id){
                case R.id.button1:
                    intent = new Intent(context, The5_1_LocalFile_Activity.class);
                    break;
                case R.id.button2:
                    intent = new Intent(context, The5_2_SharedPreference_Activity.class);
                    break;
                case R.id.button3:
                    intent = new Intent(context, The5_3_SQLite_Activity.class);
                    break;
                case R.id.button4:
                    break;
                case R.id.button5:
                    break;
                case R.id.button6:
                    break;
                case R.id.button7:
                    break;
                case R.id.button8:
                    break;
                case R.id.button9:
                    break;
                case R.id.button10:
                    break;
            }
            if (intent != null)
                startActivity(intent);
        }
    }
}
