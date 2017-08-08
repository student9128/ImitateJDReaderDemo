package com.tech.kevin.imitatejdreaderdemo;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/7/1 0:09.
 * <div>Blog: http://blog.csdn.net/student9128.</div>
 * <h3>Description:</h3>
 * <p/>
 * <p/>
 */


public class LeftRecyclerViewAdapter extends RecyclerView.Adapter<LeftRecyclerViewAdapter.MyViewHolder> {
    private List<String> data;
    private Context context;
    private SparseBooleanArray selectedItems;
    private int index =0;//默认选中第一个条目

    public LeftRecyclerViewAdapter(List<String> data, Context context) {
        this.data = data;
        this.context = context;
        this.selectedItems = new SparseBooleanArray();
    }


//    public boolean isSelected(int position) {
//        return getSelectedItems().contains(position);
//    }
//
//    public void switchSelectedState(int position) {
//        if (selectedItems.get(position, false)) {
//            selectedItems.delete(position);
//        } else {
//            selectedItems.put(position, true);
//        }
//        notifyItemChanged(position);
//    }
//
//    public void clearSelectedState() {
//        List<Integer> selection = getSelectedItems();
//        selectedItems.clear();
//        for (Integer i : selection) {
//            notifyItemChanged(i);
//        }
//    }
//
//    public int getSelectedItemCount() {
//        return selectedItems.size();
//    }

//    public List<Integer> getSelectedItems() {
//        List<Integer> items = new ArrayList<>(selectedItems.size());
//        for (int i = 0; i < selectedItems.size(); ++i) {
//            items.add(selectedItems.keyAt(i));
//        }
//        return items;
//    }

    @Override
    public LeftRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler_view_left, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final LeftRecyclerViewAdapter.MyViewHolder holder, final int position) {
        holder.textItem.setText(data.get(position));
        holder.textItem.setSelected(selectedItems.get(position, false));
        holder.textItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = position;

                if (listItemClickListener != null) {

                    listItemClickListener.onItemClick(position, holder.textItem);
                }
                notifyDataSetChanged();
            }
        });
        if (index == position) {
            holder.textItem.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
            holder.textItem.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
            holder.textItem.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
            holder.textItem.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            holder.viewLine.setVisibility(View.VISIBLE);
        } else {
            holder.textItem.setBackgroundColor(ContextCompat.getColor(context, R.color.transparent));
            holder.textItem.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
            holder.textItem.setTextColor(ContextCompat.getColor(context, R.color.black));
            holder.textItem.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
            holder.viewLine.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textItem;
        private View viewLine;

        public MyViewHolder(View itemView) {
            super(itemView);
            textItem = itemView.findViewById(R.id.tv_recycler_item);
            viewLine = itemView.findViewById(R.id.view);
        }
    }

    public void setOnRecyclerListItemClickListener(OnRecyclerListItemClickListener l) {
        listItemClickListener = l;
    }

    private OnRecyclerListItemClickListener listItemClickListener;

    public interface OnRecyclerListItemClickListener {
        void onItemClick(int position, TextView textView);
    }
}
