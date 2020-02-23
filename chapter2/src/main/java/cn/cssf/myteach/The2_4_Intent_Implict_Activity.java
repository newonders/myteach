package cn.cssf.myteach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class The2_4_Intent_Implict_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the2_4__intent__implict);

        Button button = findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("cn.cssf.myteach.INTENT");
                startActivity(intent);
            }
        });
    }
}
