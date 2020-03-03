package cn.cssf.chapter3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

public class The3_3_RecyclerView_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the3_3__recyclerview);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(The3_3_RecyclerView_Activity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecyclerFamousAdapter(The3_3_RecyclerView_Activity.this));
//        recyclerView.addItemDecoration(new SimpleItemDecoration());
        recyclerView.addItemDecoration(new DividerItemDecoration(The3_3_RecyclerView_Activity.this,
                DividerItemDecoration.VERTICAL));
    }

    /**class SimpleItemDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,
                    getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    } */
}
