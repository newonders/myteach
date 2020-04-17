package cn.cssf.chapter5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

public class The5_1_LocalFile_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the5_3__sqlite);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecyclerView recyclerView = findViewById(R.id.recyclerView);
                Context context = getApplicationContext();
                LinearLayoutManager manager = new LinearLayoutManager(context);
                UserAdapter userAdapter = new UserAdapter(
                        context,DataSource.getDataListByJsonFile(context));
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(userAdapter);
                DividerItemDecoration decoration = new DividerItemDecoration(The5_1_LocalFile_Activity.this,
                        DividerItemDecoration.VERTICAL);
//                decoration.setDrawable(R.drawable.);
                recyclerView.addItemDecoration(decoration);

            }
        });

    }
}
