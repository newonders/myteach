package cn.cssf.chapter3;

import android.content.Context;
import android.content.res.Resources;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AdapterDataSource {

    static Context context;
    static AdapterDataSource dataSource;

    public static AdapterDataSource getDataSource(Context context){
        if (dataSource == null){
            dataSource = new AdapterDataSource(context);
        }
        return dataSource;
    }

    private AdapterDataSource(Context context){
        this.context = context;
    }

    public List<Person> getPersonList(){
        List<Person> dataList = new ArrayList<>();
        List<String> cityList = getCityList();
        List<Integer> imageResouces = getImageResouceId();
        Random randomImages = new Random(); //共有24张图片，随机选取
        String famousStr = context.getString(R.string.famous);
        String[] names = famousStr.split(" ");
        for (String name : names){
            Person person = new Person();
            int index = randomImages.nextInt(24);
            person.setImageId(imageResouces.get(index));//random得到[0,23]取值
            person.setName(name);
            person.setCity(cityList.get(randomImages.nextInt(cityList.size())));
            person.setPhone(getRandomNumber());
            dataList.add(person);
        }
        return dataList;
    }

    private String getRandomNumber(){
        String[] num2 = new String[]{"3","5","7","8"};
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer("1");
        stringBuffer.append(num2[random.nextInt(4)]);
        for (int i=0; i<=7; i++) {
            stringBuffer.append(random.nextInt(10));
        }
        return stringBuffer.toString();
    }

    private List<Integer> getImageResouceId(){
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

    private List<String> getCityList(){
        String[] cityArray = context.getString(R.string.city).split(" ");
        return Arrays.asList(cityArray);
    }
}
