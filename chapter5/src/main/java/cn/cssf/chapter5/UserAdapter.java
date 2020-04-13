package cn.cssf.chapter5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter {
    private List<User> dataList;
    private LayoutInflater layoutInflater;
    private Context context;

    public UserAdapter(Context context, List<User> dataList){
        this.dataList = dataList;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.user_item, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.nameTv = view.findViewById(R.id.nameTv);
        viewHolder.phoneTv = view.findViewById(R.id.phoneTv);
        viewHolder.departmentTv = view.findViewById(R.id.departmentTv);
        viewHolder.imageView = view.findViewById(R.id.imageView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final User user = dataList.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.imageView.setImageResource(user.getImageId());
        viewHolder.nameTv.setText(user.getUserName());
        viewHolder.departmentTv.setText(user.getDepartment());
        viewHolder.phoneTv.setText(user.getMobilePhone());
        viewHolder.updateBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((The5_3_SQLite_Activity)context).showAddDialog(user);
            }
        });
        viewHolder.deleteBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((The5_3_SQLite_Activity)context).showDeleteDialog(user.getWorkId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView nameTv, departmentTv, phoneTv;
        Button updateBt, deleteBt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.nameTv);
            departmentTv = itemView.findViewById(R.id.departmentTv);
            phoneTv = itemView.findViewById(R.id.phoneTv);
            imageView = itemView.findViewById(R.id.imageView);
            updateBt = itemView.findViewById(R.id.bt_update);
            deleteBt = itemView.findViewById(R.id.bt_delete);
        }
    }

    public void setDataList(List<User> users){
        this.dataList = users;
    }
}
