package com.tech.kevin.imitatejdreaderdemo;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

/**
 * Created by <a href="http://blog.csdn.net/student9128">JingPeng</a> on 2017/7/25.
 * <p>
 * <h3>Description:</h3>
 * <p>
 * <p/>
 */


public class RecyclerViewLeftAdapter extends RecyclerView.Adapter<RecyclerViewLeftAdapter.MyViewHolder> {
    private Context context;
    private List<String> data;
    private int index = 0;


    public RecyclerViewLeftAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }

    public void updateData(List<String> d) {
        data.clear();
        data.addAll(d);
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_item_recycler_left, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.textView.setText(data.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = position;
                if (listener != null) {
                    listener.onLeftItemClick(position);
                }
//                ToastUtils.showToast(context, data.get(position));
//                holder.textView.setBackgroundResource(R.color.white);
                notifyDataSetChanged();
            }
        });
        if (index == position) {
            holder.textView.setBackgroundColor(ContextCompat.getColor(context, R.color.white_1));
            holder.textView.setTextColor(ContextCompat.getColor(context, R.color.orange));
            holder.viewLine.setVisibility(View.VISIBLE);
        } else {
            holder.textView.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
            holder.textView.setTextColor(ContextCompat.getColor(context, R.color.black));
            holder.viewLine.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        View viewLine;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_text);
            viewLine = itemView.findViewById(R.id.view);
        }
    }

    public void setOnRecyclerItemClickListener(OnItemClickListener l) {
        listener = l;
    }

    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onLeftItemClick(int position);
    }
}
