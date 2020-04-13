package cn.cssf.chapter5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;
import java.util.Random;

public class The5_3_SQLite_Activity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;

    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the5_3__sqlite);
        dbHelper = new MyDatabaseHelper(getApplicationContext(),
                MyDatabaseHelper.DB_NAME, null, 1);
        Button createDb = findViewById(R.id.createDb);
        createDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                List<User> userList = DataSource.getDataListByJsonFile(The5_3_SQLite_Activity.this);
                // 开始组装
                for (User user : userList){
                    dbHelper.addUser(db, user);
                }

                RecyclerView recyclerView = findViewById(R.id.rcview_53);
                LinearLayoutManager layoutManager = new LinearLayoutManager(The5_3_SQLite_Activity.this);
                recyclerView.setLayoutManager(layoutManager);
                List<User> users = DataSource.getDataListByDb(getApplicationContext(),dbHelper);
                Log.d(The5_3_SQLite_Activity.class.getName(), "onClick: " + users.size());
                adapter = new UserAdapter(The5_3_SQLite_Activity.this,users);
                recyclerView.setAdapter(adapter);
                recyclerView.addItemDecoration(new DividerItemDecoration(The5_3_SQLite_Activity.this,
                        DividerItemDecoration.VERTICAL));
            }
        });

        Button deleteDb = findViewById(R.id.deleteDb);
        deleteDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.deleteDb(getApplicationContext());
            }
        });

        Button addData = findViewById(R.id.addBt);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddDialog(null);
            }
        });
    }

    //增加联系人或者修改联系人均使用该对话框
    //若是修改联系人，则先把原数据写入对话框
    public void showAddDialog(final User user) {
        LayoutInflater factory = LayoutInflater.from(this);
        final View textEntryView = factory.inflate(R.layout.dialog_add, null);
        final EditText editTextName = textEntryView.findViewById(R.id.et_name);
        final EditText editTextWorkid = textEntryView.findViewById(R.id.et_workid);
        final EditText editTextPhone = textEntryView.findViewById(R.id.et_phone);
        final EditText editTextDepart= textEntryView.findViewById(R.id.et_dept);
        if (user != null){
            editTextName.setText(user.getUserName());
            editTextWorkid.setText(user.getWorkId());
            editTextPhone.setText(user.getMobilePhone());
            editTextDepart.setText(user.getDepartment());
        }
        AlertDialog.Builder dialog = new AlertDialog.Builder(The5_3_SQLite_Activity.this);
        if (user == null){
            dialog.setTitle("增加联系人");
        }else
            dialog.setTitle("修改联系人");

        dialog.setIcon(android.R.drawable.ic_dialog_info);
        dialog.setView(textEntryView);
        dialog.setPositiveButton("提交", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int i) {
                Log.i("111111", editTextName.getText().toString());
                User person = new User();
                person.setUserName(editTextName.getText().toString());
                person.setWorkId(editTextWorkid.getText().toString());
                person.setMobilePhone(editTextPhone.getText().toString());
                person.setDepartment(editTextDepart.getText().toString());
                if (user == null){
                    List<Integer> imageResouces = DataSource.getImageResouceId(The5_3_SQLite_Activity.this);
                    Random random = new Random();
                    person.setImageId(imageResouces.get(random.nextInt(24)));
                    dbHelper.addUser(dbHelper.getWritableDatabase(),person);
                }else {
                    person.setImageId(user.getImageId());
                    dbHelper.updateUser(dbHelper.getWritableDatabase(),person);
                }
                reflush();
            }
        });
        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int i) {

            }
        });
        dialog.show();// 显示对话框
    }

    public void showDeleteDialog(final String workId) {
        AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(The5_3_SQLite_Activity.this);
        normalDialog.setIcon(android.R.drawable.ic_dialog_alert);
        normalDialog.setTitle("删除联系人");
        normalDialog.setMessage("是否删除 " + workId + " 这条联系人记录");
        normalDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SQLiteDatabase db = dbHelper.getWritableDatabase();
                        db.delete("User", "workId = ?", new String[] { workId });
                        reflush();
                    }
                });
        normalDialog.setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        // 显示对话框
        normalDialog.show();
    }

    private void reflush() {
        ((UserAdapter)adapter).setDataList(DataSource.getDataListByDb(
                The5_3_SQLite_Activity.this, dbHelper));
        adapter.notifyDataSetChanged();

    }


}
