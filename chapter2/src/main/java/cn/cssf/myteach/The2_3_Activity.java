package cn.cssf.myteach;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class The2_3_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        ButtonOnClickListener listener = new ButtonOnClickListener(The2_3_Activity.this);
        button.setOnClickListener(listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "点击的是添加", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(this, "点击的是删除", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}

class ButtonOnClickListener implements View.OnClickListener{
    private Context context;
    public ButtonOnClickListener(Context context){
        this.context = context;
    }
    @Override
    public void onClick(View view) {
        Toast.makeText(context, "按钮被点击了...", Toast.LENGTH_SHORT).show();
    }
}