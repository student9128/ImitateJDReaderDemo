package com.tech.kevin.imitatejdreaderdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by <a href="http://blog.csdn.net/student9128">JingPeng</a> on 2017/7/26.
 * <p>
 * <h3>Description:</h3>
 * <p/>
 * <p/>
 */


public class RecyclerViewRightAdapter extends RecyclerView.Adapter<RecyclerViewRightAdapter.MyViewHolder> {
    private Context context;
    private List<String> data;
    private int[] icon;

    public RecyclerViewRightAdapter(List<String> data) {
        this.data = data;
    }

    public RecyclerViewRightAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }

    public RecyclerViewRightAdapter(Context context, List<String> data, int[] icon) {
        this.context = context;
        this.data = data;
        this.icon = icon;
    }

    public void addItem() {
//        data.add("xxx");
        notifyItemInserted(0);
    }

    public void updateData(List<String> d) {
        data.clear();
        data.addAll(d);
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item_recycler_right, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
//        holder.imageView.setImageResource(icon[position]);
//        String img = lineTypeBean.getTypeName().trim();
//        if ("存款类".equals(img)) {
//            holder.imageView.setImageResource(R.drawable.ic_repository_deposit);
//        } else if ("贷款类".equals(img)) {
//            holder.imageView.setImageResource(R.drawable.ic_repository_loan);
//        } else if ("利润类".equals(img)) {
//            holder.imageView.setImageResource(R.drawable.ic_repository_profits);
//        } else if ("客户类".equals(img)) {
//            holder.imageView.setImageResource(R.drawable.ic_repository_customer);
//        } else if ("发放类".equals(img)) {
//            holder.imageView.setImageResource(R.drawable.ic_repository_issue);
//        } else if ("营运类".equals(img)) {
//            holder.imageView.setImageResource(R.drawable.ic_repository_operating);
//        } else if ("中收类".equals(img)) {
//            holder.imageView.setImageResource(R.drawable.ic_repository_intheclosed);
//        } else if ("全部类".equals(img)) {
//            holder.imageView.setImageResource(R.drawable.ic_repository_all);
//        }
//        String typeIcon = lineTypeBean.getTypeIcon();//icon name
        holder.textView.setText(data.get(position));
        holder.llItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onRightItemClick(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        LinearLayout llItem;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_image);
            textView = (TextView) itemView.findViewById(R.id.tv_text);
            llItem = (LinearLayout) itemView.findViewById(R.id.ll_item);
        }
    }

    public void setOnRightItemClickListener(OnRightItemClickListener l) {
        listener = l;
    }

    private OnRightItemClickListener listener;

    public interface OnRightItemClickListener {
        void onRightItemClick(int position);
    }
}
