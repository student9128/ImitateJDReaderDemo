package com.tech.kevin.imitatejdreaderdemo;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.LinearInterpolator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/3/24.
 * <p>
 * <h3>Description:</h3>
 * <p>
 * <p/>
 */


public class RecyclerViewActivity extends BaseActivity implements View.OnClickListener, RecyclerViewLeftAdapter.OnItemClickListener, RecyclerViewRightAdapter.OnRightItemClickListener {
    private RecyclerView mRecyclerView, mRecyclerViewRight;
    private List<String> dataTitle = new ArrayList<>();
    private RecyclerViewLeftAdapter indexQueryLeftAdapter;

    private List<String> data = new ArrayList<>();
    private RecyclerViewRightAdapter indexQueryRightAdapter;
    private String taskPasition;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    protected int setLayoutResId() {
        return R.layout.activity_recycler_view;
    }

    @Override
    public void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_recycler_view_left);
        mRecyclerViewRight = (RecyclerView) findViewById(R.id.rv_recycler_view_right);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        for (int i = 0; i < 20; i++) {
            dataTitle.add("Android:\t" + i);
        }
        indexQueryLeftAdapter = new RecyclerViewLeftAdapter(this, dataTitle);
        mRecyclerView.setAdapter(indexQueryLeftAdapter);
        indexQueryLeftAdapter.setOnRecyclerItemClickListener(this);

        mRecyclerViewRight.setLayoutManager(new GridLayoutManager(this, 3));
        for (int i = 0; i < 11; i++) {
            data.add("" + i);
        }
        indexQueryRightAdapter = new RecyclerViewRightAdapter(this, data);
        mRecyclerViewRight.setAdapter(indexQueryRightAdapter);
        indexQueryRightAdapter.setOnRightItemClickListener(this);
        mRecyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        mRecyclerViewRight.setOverScrollMode(View.OVER_SCROLL_NEVER);
    }

    @Override
    public void initData() {
        doPostQuery();


    }

    private void doPostQuery() {

    }

    @Override
    public void initListener() {


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }

    @Override
    public void onLeftItemClick(int position) {
        taskPasition = dataTitle.get(position);
        List<String> lineType = new ArrayList<>();
        for (int i = 0; i < Math.random() * 10; i++) {
            lineType.add(Integer.parseInt(new DecimalFormat("0").format(Math.random() * 10)) + "");
        }
        indexQueryRightAdapter.updateData(lineType);
        scrollToTop(position);
    }

    @Override
    public void onRightItemClick(int position) {

//        showToast("You clicked:\t" + position);
        ToastUtils.showKevinToast(this, "You clicked:\t" + position, R.drawable.ic_tip);
    }

    private void scrollToTop(int n) {
        //先从RecyclerView的LayoutManager中获取第一项和最后一项的Position
        int firstItem = mLinearLayoutManager.findFirstVisibleItemPosition();
        int lastItem = mLinearLayoutManager.findLastVisibleItemPosition();
        printLogd("firstItem:\t" + firstItem);
        printLogd("lastItem:\t" + lastItem);
        //然后区分情况
        if (n <= firstItem) {
            //当要置顶的项在当前显示的第一个项的前面时
//            rvRecyclerView.scrollToPosition(n);//有bug
            mRecyclerView.smoothScrollBy(0, mRecyclerView.getChildAt(n - firstItem).getTop(), new LinearInterpolator());
        } else if (n <= lastItem) {
            //当要置顶的项已经在屏幕上显示时
            int top = mRecyclerView.getChildAt(n - firstItem).getTop();
            mRecyclerView.smoothScrollBy(0, top, new LinearInterpolator());
//            mRecyclerView.smoothScrollToPosition(n);
        } else {
            //当要置顶的项在当前显示的最后一项的后面时
            mRecyclerView.scrollToPosition(n);

            //这里这个变量是用在RecyclerView滚动监听里面的
//            move = true;
        }

    }
}
