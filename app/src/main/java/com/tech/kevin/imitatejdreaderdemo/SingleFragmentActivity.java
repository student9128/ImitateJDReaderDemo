package com.tech.kevin.imitatejdreaderdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Kevin on 2017/6/30.
 * <div>Blog: http://blog.csdn.net/student9128.</div>
 * <h3>Description:</h3>
 * <p/>
 * <p/>
 */


public class SingleFragmentActivity extends BaseActivity {
    @BindView(R.id.rv_recycler_view)
    RecyclerView rvRecyclerView;
    @BindView(R.id.fl_frame_layout)
    FrameLayout flFrameLayout;
    private List<String> mData = new ArrayList<>();

    @Override
    protected int setLayoutResId() {
        return R.layout.activity_sigle_fragment;
    }

    @Override
    public void initView() {
        rvRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        fillData();
        LeftRecyclerViewAdapter adapter = new LeftRecyclerViewAdapter(mData,this);
        rvRecyclerView.setAdapter(adapter);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(R.id.fl_frame_layout, new SingleFragment()).commit();
    }

    private void fillData() {
        for (int i = 0; i < 10; i++) {
            mData.add("Item" + i);
        }
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

}
