package com.tech.kevin.imitatejdreaderdemo;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/6/30.
 * <div>Blog: http://blog.csdn.net/student9128.</div>
 * <h3>Description:</h3>
 * <p/>
 * <p/>
 */


public class MultiFragmentActivity extends BaseActivity implements LeftRecyclerViewAdapter.OnRecyclerListItemClickListener {
    @BindView(R.id.rv_recycler_view)
    RecyclerView rvRecyclerView;
    @BindView(R.id.fl_frame_layout)
    FrameLayout flFrameLayout;
    private List<String> mData = new ArrayList<>();
    private LeftRecyclerViewAdapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;


    @Override
    protected int setLayoutResId() {
        return R.layout.activity_multi_fragment;
    }

    @Override
    public void initView() {
        mLinearLayoutManager = new LinearLayoutManager(this);
        rvRecyclerView.setLayoutManager(mLinearLayoutManager);
        fillData();
        mAdapter = new LeftRecyclerViewAdapter(mData, this);
        rvRecyclerView.setAdapter(mAdapter);
        rvRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mAdapter.setOnRecyclerListItemClickListener(this);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(R.id.fl_frame_layout, new MultiFragment()).commit();
    }

    private void fillData() {
        for (int i = 0; i < 100; i++) {
            mData.add("Item" + i);
        }
    }

    @Override
    public void initData() {


    }

    @Override
    public void initListener() {
        rvRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

    }

    @Override
    public void onItemClick(int position, TextView textView) {
        ToastUtils.showToast(this, "Click\t" + position);
        LogK.d("Multi", "position:\t" + position);
        int firstVisibleItemPosition = mLinearLayoutManager.findFirstVisibleItemPosition();
        int lastVisibleItemPosition = mLinearLayoutManager.findLastVisibleItemPosition();
        int lastCompletelyVisibleItemPosition = mLinearLayoutManager.findLastCompletelyVisibleItemPosition();
        printLogd("first:" + firstVisibleItemPosition);
        printLogd("last:" + lastVisibleItemPosition);
        printLogd("lastCom:" + lastCompletelyVisibleItemPosition);
        int mVisibleCount = mLinearLayoutManager.findLastVisibleItemPosition()
                - mLinearLayoutManager.findFirstVisibleItemPosition() + 1;
        printLogd("visibleCount:" + mVisibleCount);
        moveToPosition(position);
    }


    private void moveToPosition(int n) {
        //先从RecyclerView的LayoutManager中获取第一项和最后一项的Position
        int firstItem = mLinearLayoutManager.findFirstVisibleItemPosition();
        int lastItem = mLinearLayoutManager.findLastVisibleItemPosition();
        printLogd("firstItem:\t" + firstItem);
        printLogd("lastItem:\t" + lastItem);
        //然后区分情况
        if (n <= firstItem) {
            //当要置顶的项在当前显示的第一个项的前面时
//            rvRecyclerView.scrollToPosition(n);//有bug
            rvRecyclerView.smoothScrollBy(0, rvRecyclerView.getChildAt(n - firstItem).getTop(), new LinearInterpolator());
        } else if (n <= lastItem) {
            //当要置顶的项已经在屏幕上显示时
            int top = rvRecyclerView.getChildAt(n - firstItem).getTop();
            rvRecyclerView.smoothScrollBy(0, top, new LinearInterpolator());
//            rvRecyclerView.smoothScrollToPosition(n);
        } else {
            //当要置顶的项在当前显示的最后一项的后面时
            rvRecyclerView.scrollToPosition(n);

            //这里这个变量是用在RecyclerView滚动监听里面的
//            move = true;
        }

    }
}
