package com.tech.kevin.imitatejdreaderdemo;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by <a href="http://blog.csdn.net/student9128">JingPeng</a> on 2017/3/24.
 * <p>
 * <h3>Description:</h3>
 * <p>
 * <p/>
 */


public class RecyclerViewActivity extends BaseActivity implements View.OnClickListener, RecyclerViewLeftAdapter.OnItemClickListener, RecyclerViewRightAdapter.OnRightItemClickListener {
    private TextView mTitle;
    private ImageView mBack;
    private EditText mEtIndexName;
    private TextView mTvIndexNameSearch;
    private ImageView mIvSearch;
    private RecyclerView mRecyclerView, mRecyclerViewRight;
    private FrameLayout mFlContent;
    private List<String> dataTitle = new ArrayList<>();
    private RecyclerViewLeftAdapter indexQueryLeftAdapter;
    private TextView mTvIndexQuerySortName;
    //    private IndexQueryFragment fragment;
    private FragmentTransaction beginTransaction;
    private LinearLayout mLlSearchBox;

    //    private int[] icon = new int[]{R.drawable.ic_repository_deposit, R.drawable.ic_repository_customer,
//            R.drawable.ic_repository_intheclosed, R.drawable.ic_repository_issue, R.drawable.ic_repository_loan,
//            R.drawable.ic_repository_operating, R.drawable.ic_repository_all};
    private List<String> data = new ArrayList<>();
    private RecyclerViewRightAdapter indexQueryRightAdapter;
    private String taskPasition;

    @Override
    protected int setLayoutResId() {
        return R.layout.activity_recycler_view;
    }

    @Override
    public void initView() {
//        mTitle = (TextView) findViewById(R.id.tv_title);
//        mBack = (ImageView) findViewById(R.id.iv_back);
//        mTvIndexNameSearch = (TextView) findViewById(R.id.tv_index_name_search);
//        mLlSearchBox = (LinearLayout) findViewById(R.id.ll_search_box);
////        mEtIndexName = (EditText) findViewById(R.id.et_index_name);
//        mIvSearch = (ImageView) findViewById(R.id.iv_search);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_recycler_view_left);
        mRecyclerViewRight = (RecyclerView) findViewById(R.id.rv_recycler_view_right);
//        mTvIndexQuerySortName = (TextView) findViewById(R.id.tv_index_query_sort_name);
//        mFlContent = (FrameLayout) findViewById(R.id.fl_content);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        for (int i = 0; i < 20; i++) {
            dataTitle.add("Title:\t" + i);
        }
        indexQueryLeftAdapter = new RecyclerViewLeftAdapter(this, dataTitle);
        mRecyclerView.setAdapter(indexQueryLeftAdapter);
        indexQueryLeftAdapter.setOnRecyclerItemClickListener(this);
        beginTransaction = getSupportFragmentManager().beginTransaction();
//        fragment = new IndexQueryFragment();
//        beginTransaction.add(R.id.fl_content, fragment).commit();

        mRecyclerViewRight.setLayoutManager(new GridLayoutManager(this, 3));
        for (int i = 0; i < 170; i++) {
            data.add("xx\t" + i);
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
//        mTvIndexQuerySortName.setText(dataTitle.get(position) + "指标分类");
//        indexQueryRightAdapter.addItem();
        taskPasition = dataTitle.get(position);
        List<String> lineType = new ArrayList<>();
        for (int i = 0; i < Math.random() * 150; i++) {
            lineType.add("xxx" + i);
        }
        indexQueryRightAdapter.updateData(lineType);
    }

    @Override
    public void onRightItemClick(int position) {

        showToast("You clicked:\t" + position);
    }
}
