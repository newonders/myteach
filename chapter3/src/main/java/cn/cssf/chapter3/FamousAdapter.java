package cn.cssf.chapter3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FamousAdapter extends BaseAdapter {

    Context context;
    List<Person> dataList;
    LayoutInflater layoutInflater;

    public List<Person> getDataList() {
        return dataList;
    }

    public FamousAdapter(Context context){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        dataList = DataSource.getDataSource(context).getPersonList();
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Person thePerson = (Person)getItem(i);
        ViewHolder viewHolder = null;
        if (view == null){
            view = layoutInflater.inflate(R.layout.listview_item,viewGroup,false);
            ImageView imageView = view.findViewById(R.id.imageView);
            TextView nameTv = view.findViewById(R.id.nameTv),
                    cityTv = view.findViewById(R.id.cityTv),
                    companyTv = view.findViewById(R.id.companyTv),
                    phoneTv = view.findViewById(R.id.phoneTv);
            viewHolder = new ViewHolder();
            viewHolder.imageView = imageView;
            viewHolder.nameTv = nameTv;
            viewHolder.cityTv = cityTv;
            viewHolder.companyTv = companyTv;
            viewHolder.phoneTv = phoneTv;
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.imageView.setImageResource(thePerson.getImageId());
        viewHolder.nameTv.setText(thePerson.getName());
        viewHolder.cityTv.setText(thePerson.getCity());
        viewHolder.companyTv.setText(thePerson.getCompany());
        viewHolder.phoneTv.setText(thePerson.getPhone());
        return view;
    }

    class ViewHolder{
        ImageView imageView;
        TextView nameTv,cityTv,companyTv,phoneTv;
    }
}
