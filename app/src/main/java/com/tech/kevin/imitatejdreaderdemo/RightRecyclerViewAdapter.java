package com.tech.kevin.imitatejdreaderdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/7/14 21:18.
 * <div>Blog: http://blog.csdn.net/student9128.</div>
 * <h3>Description:</h3>
 * <p/>
 * <p/>
 */


public class RightRecyclerViewAdapter extends RecyclerView.Adapter<RightRecyclerViewAdapter.MyViewHolder> {
    private Context context;
    private List<RightRecyclerViewBean> data;

    public RightRecyclerViewAdapter(Context context, List<RightRecyclerViewBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RightRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler_view_right, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RightRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.imageView.setImageResource(data.get(position).getImageRes());
        holder.textItem1.setText(data.get(position).getItem1());
        holder.textItem2.setText(data.get(position).getItem2());
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textItem1, textItem2;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_recycler_image);
            textItem1 = itemView.findViewById(R.id.tv_recycler_item_1);
            textItem2 = itemView.findViewById(R.id.tv_recycler_item_2);
        }
    }
}
