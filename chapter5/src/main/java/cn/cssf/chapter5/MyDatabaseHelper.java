package cn.cssf.chapter5;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "User.db";

    public static final String CREATE_USER = "create table User ("
            + "userName text, "
            + "workId integer, "
            + "mobilePhone text, "
            + "department text,"
            + "imageId integer)";

    public static final String CREATE_DEPARTMENT = "create table Department ("
            + "id integer primary key autoincrement, "
            + "department text, "
            + "dept_code integer)";

    private Context mContext;

    public MyDatabaseHelper(Context context, String name,
                            SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER);
        db.execSQL(CREATE_DEPARTMENT);
        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists User");
        db.execSQL("drop table if exists Department");
        onCreate(db);
    }


    public void deleteDb(Context context) {
        context.deleteDatabase(DB_NAME);
    }

    public void addUser(SQLiteDatabase db, User user){
        ContentValues values = new ContentValues();
        values.put("userName",user.getUserName());
        values.put("workId",user.getWorkId());
        values.put("mobilePhone",user.getMobilePhone());
        values.put("department",user.getDepartment());
        values.put("imageId",user.getImageId());
        db.insert("User", null, values);
    }

    //仅提供用workid作为条件的数据修改
    public void updateUser(SQLiteDatabase db, User user){
        ContentValues values = new ContentValues();
        if (user.getUserName() != null){
            values.put("userName",user.getUserName());
        }
        if (user.getMobilePhone() != null){
            values.put("mobilePhone",user.getMobilePhone());
        }
        if (user.getDepartment() != null){
            values.put("department",user.getDepartment());
        }
        db.update("User", values, "workId = ?", new String[] {user.getWorkId()});
    }
}
