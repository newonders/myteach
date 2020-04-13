package cn.cssf.chapter5;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataSource {

    public static List<User> getDataListByJsonFile(Context context){
        InputStream inputStream = context.getResources().openRawResource(R.raw.userlist);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer stringBuffer = new StringBuffer();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                stringBuffer.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        List<User> users = JSON.parseArray(stringBuffer.toString(), User.class);
        List<Integer> imageResouces = getImageResouceId(context);
        Random random = new Random();
        for (User user : users)
            user.setImageId(imageResouces.get(random.nextInt(24)));
        return users;
    }

    public static List<Integer> getImageResouceId(Context context){
        Resources resources = context.getResources();
        List<Integer> list = new ArrayList<Integer>();
        Field[] fields = R.drawable.class.getFields();
        for (Field field : fields){
            field.setAccessible(true);
            String name = field.getName();
            if (name.startsWith("f")){
                int resouceId = resources.getIdentifier(name,"drawable",
                        context.getPackageName());
                list.add(resouceId);
            }
        }
        return list;
    }

    public static List<User> getDataListByDb(Context context, SQLiteOpenHelper dbHelper){
        List<User> users = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // 查询Book表中所有的数据
        Cursor cursor = db.query("User", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                // 遍历Cursor对象，取出数据并打印
                String userName = cursor.getString(cursor.getColumnIndex("userName"));
                String workId = cursor.getString(cursor.getColumnIndex("workId"));
                String mobilePhone = cursor.getString(cursor.getColumnIndex("mobilePhone"));
                String department = cursor.getString(cursor.getColumnIndex("department"));
                int imageId = cursor.getInt(cursor.getColumnIndex("imageId"));
                User user = new User();
                user.setImageId(imageId);
                user.setDepartment(department);
                user.setUserName(userName);
                user.setWorkId(workId);
                user.setMobilePhone(mobilePhone);
                users.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return users;
    }
}
