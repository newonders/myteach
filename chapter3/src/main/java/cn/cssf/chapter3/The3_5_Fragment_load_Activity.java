package cn.cssf.chapter3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.SearchView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import cn.cssf.chapter3.fragment.ClassTableFragment;
import cn.cssf.chapter3.fragment.StaticRightFragment;

public class The3_5_Fragment_load_Activity extends AppCompatActivity
        implements StaticRightFragment.OnFragmentInteractionListener{

    private Fragment staticRightFragment, classTableFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the3_5__fragment_load);
        fragmentManager = getSupportFragmentManager();
        staticRightFragment = new StaticRightFragment();
        classTableFragment = new ClassTableFragment();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.contact:
                                setTheFragment(0); break;
                            case R.id.class_table:
                                setTheFragment(1); break;
                        }
                        return true;
                    }
                });
        SearchView searchView = findViewById(R.id.searchView);
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //当点击搜索按钮时触发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("The3_5_Activity", "onQueryTextSubmit: " + query);
                ((StaticRightFragment)staticRightFragment).reFlush(query,null);
                return false;
            }

            //当搜索内容改变时触发该方法
            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("The3_5_Activity", "onQueryTextChange: " + newText);
                ((StaticRightFragment)staticRightFragment).reFlush(newText,null);
                return false;
            }
        });
    }

    private void setTheFragment(int index){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (index == 0)
            fragmentTransaction.replace(R.id.frameLayout,staticRightFragment);
        else if (index == 1)
            fragmentTransaction.replace(R.id.frameLayout,classTableFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteraction(String message) {

    }
}
