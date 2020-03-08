package cn.cssf.chapter3;

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
        button1.setText("LinearLayout");
        button2.setText("RelativeLayout");
        button3.setText("ConstraintLayout");
        button4.setText("ListView");
        button5.setText("RecyclerView");
        button6.setText("Task1");
        button7.setText("Fragment静态创建");
        button8.setText("Fragment动态创建");
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
                    intent = new Intent(context, The3_1_LinearLayout_Activity.class);
                    break;
                case R.id.button2:
                    intent = new Intent(context, The3_1_RelativeLayout_Activity.class);
                    break;
                case R.id.button3:
                    intent = new Intent(context, The3_2_ConstraintLayout_Activity.class);
                    break;
                case R.id.button4:
                    intent = new Intent(context, The3_3_ListView_Activity.class);
                    break;
                case R.id.button5:
                    intent = new Intent(context, The3_3_RecyclerView_Activity.class);
                    break;
                case R.id.button6:
                    intent = new Intent(context, The3_4_Task1_Activity.class);
                    break;
                case R.id.button7:
                    intent = new Intent(context, The3_5_Fragment_xml_Activity.class);
                    break;
                case R.id.button8:
                    intent = new Intent(context, The3_5_Fragment_load_Activity.class);
                    break;
                case R.id.button9:
                    break;
                case R.id.button10:
                    break;
            }
            if (null != intent)
                startActivity(intent);
        }
    }

}
