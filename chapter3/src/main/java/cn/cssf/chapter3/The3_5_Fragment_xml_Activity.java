package cn.cssf.chapter3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;

import cn.cssf.chapter3.fragment.StaticLeftFragment;
import cn.cssf.chapter3.fragment.StaticRightFragment;

public class The3_5_Fragment_xml_Activity extends AppCompatActivity
    implements StaticLeftFragment.OnFragmentInteractionListener,
               StaticRightFragment.OnFragmentInteractionListener {
    private Fragment leftFragment, rightFragment;
    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the3_5__fragment__xml);
        leftFragment = getSupportFragmentManager().findFragmentById(R.id.staticLeftFragment);
        rightFragment = getSupportFragmentManager().findFragmentById(R.id.staticRightFragment);
        searchView = findViewById(R.id.searchView);
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //当点击搜索按钮时触发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("The3_5_Activity", "onQueryTextSubmit: " + query);
                ((StaticRightFragment)rightFragment).reFlush(query,null);
                return false;
            }

            //当搜索内容改变时触发该方法
            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("The3_5_Activity", "onQueryTextChange: " + newText);
                ((StaticRightFragment)rightFragment).reFlush(newText,null);
                return false;
            }
        });
    }

    @Override
    public void onFragmentInteraction(String name, String company) {
//        Log.d("onFragmentInteraction", company);
        ((StaticRightFragment)rightFragment).reFlush(name,company);
    }

    @Override
    public void onFragmentInteraction(String message) {}
}
