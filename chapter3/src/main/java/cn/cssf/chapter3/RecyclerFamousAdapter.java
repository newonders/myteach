package cn.cssf.chapter3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerFamousAdapter extends RecyclerView.Adapter<RecyclerFamousAdapter.ViewHolder> {

    List<Person> dataList;
    Context context;
    LayoutInflater layoutInflater;

    public RecyclerFamousAdapter(Context context){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        dataList = AdapterDataSource.getDataSource(context).getPersonList();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.listview_item,
                parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Person thePerson = dataList.get(position);
        holder.imageView.setImageResource(thePerson.getImageId());
        holder.nameTv.setText(thePerson.getName());
        holder.cityTv.setText(thePerson.getCity());
        holder.phoneTv.setText(thePerson.getPhone());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView nameTv, cityTv, phoneTv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            nameTv = itemView.findViewById(R.id.nameTv);
            cityTv = itemView.findViewById(R.id.cityTv);
            phoneTv = itemView.findViewById(R.id.phoneTv);
        }
    }
}
