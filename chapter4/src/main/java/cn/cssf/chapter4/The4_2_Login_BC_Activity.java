package cn.cssf.chapter4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class The4_2_Login_BC_Activity extends The4_2_BaseActivity {

    private final static String USERNAME = "1";
    private final static String PASSWORD = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the4_2__login__bc);

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextName = findViewById(R.id.et_username);
                EditText editTextPass = findViewById(R.id.et_password);
                String nameString = editTextName.getText().toString();
                String passString = editTextPass.getText().toString();
                if (nameString.equals(USERNAME) && passString.equals(PASSWORD)){
                    isLogin = true;
                    Intent intent = new Intent(The4_2_Login_BC_Activity.this,
                            The4_2_Task_Activity.class);
                    intent.putExtra("name",nameString);
                    startActivity(intent);
                }
            }
        });
    }
}
