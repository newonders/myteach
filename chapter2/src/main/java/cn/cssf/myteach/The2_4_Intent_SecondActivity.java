package cn.cssf.myteach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class The2_4_Intent_SecondActivity extends AppCompatActivity {

    private int counter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the2_4__intent__second);

        Button button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(The2_4_Intent_SecondActivity.this,The2_4_Intent_Activity.class);
                intent.putExtra("counter",counter + "");
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        if (intent == null){
            return;
        }
        String counterStr = intent.getStringExtra("counter");

        TextView textView = findViewById(R.id.textView4);
        textView.setText(counterStr);
        try {
            counter = Integer.parseInt(counterStr) + 1;
        }catch (Exception e){

        }


    }
}
