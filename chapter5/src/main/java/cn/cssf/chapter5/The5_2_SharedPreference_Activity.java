package cn.cssf.chapter5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class The5_2_SharedPreference_Activity extends AppCompatActivity {

    private final static String USER_NAME = "2015";
    private final static String PASS_WORD = "2015";

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the5_2_sharedpreference);

        final EditText et_username = findViewById(R.id.et_username);
        final EditText et_password = findViewById(R.id.et_password);
        final CheckBox checkBox = findViewById(R.id.checkBox);
        Button button = findViewById(R.id.btn_login);

        buildSharedPreferences();
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        boolean isRemember = sharedPreferences.getBoolean("remember",false);

        if (isRemember){
            et_username.setText(sharedPreferences.getString("username",""));
            et_password.setText(sharedPreferences.getString("password",""));
            checkBox.setChecked(true);
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (et_username.getText().toString().equals(USER_NAME)
                        && et_password.getText().toString().equals(PASS_WORD)){
                    if (checkBox.isChecked()){
                        editor.putString("username",USER_NAME);
                        editor.putString("password",PASS_WORD);
                        editor.putBoolean("remember",true);
                    }
                    else {
                        editor.clear();
                    }
                    editor.apply();
                    Toast.makeText(The5_2_SharedPreference_Activity.this,
                            "登录成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(The5_2_SharedPreference_Activity.this,
                            MainActivity.class);
                    finish();

                }else {
                    Toast.makeText(The5_2_SharedPreference_Activity.this,
                            "登录错误", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    private void buildSharedPreferences(){
        //方式一
//        sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
        //方式二
//        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(The5_2_SharedPreference_Activity.this);
        //方式三
        sharedPreferences = this.getPreferences(MODE_PRIVATE);
    }
}
