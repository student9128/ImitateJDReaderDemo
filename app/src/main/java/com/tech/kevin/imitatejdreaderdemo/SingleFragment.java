package com.tech.kevin.imitatejdreaderdemo;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/6/30 23:56.
 * <div>Blog: http://blog.csdn.net/student9128.</div>
 * <h3>Description:</h3>
 * <p/>
 * <p/>
 */


public class SingleFragment extends BaseFragment {
    @BindView(R.id.rv_recycler_view)
    RecyclerView rvRecyclerView;
    @BindView(R.id.tv_tip)
    TextView tvTip;
    Unbinder unbinder;
    private List<String> item1 = new ArrayList<>();
    private List<String> item2 = new ArrayList<>();
    private List<Integer> imageRes = new ArrayList<>();
    private List<RightRecyclerViewBean> rightRecyclerViewData = new ArrayList<>();
    private RightRecyclerViewBean rightRecyclerViewBean;

    @Override
    public int setLayoutResId() {
        return R.layout.fragment_single;
    }

    @Override
    public void initView() {
        rvRecyclerView.setLayoutManager(new GridLayoutManager(mActivity, 2));
    }

    @Override
    public void initData() {
        rightRecyclerViewBean = new RightRecyclerViewBean();
//        initItem1();
//        initItem2();
        initResource();
        RightRecyclerViewAdapter adapter = new RightRecyclerViewAdapter(getActivity(), rightRecyclerViewData);
        rvRecyclerView.setAdapter(adapter);
    }

    private void initResource() {
        for (int i = 0; i < 140; i++) {
//            imageRes.add(R.mipmap.ic_launcher_round);
            rightRecyclerViewBean.setItem1("Item1\t" + i);
            rightRecyclerViewBean.setItem2("Item2\t" + i);
            rightRecyclerViewBean.setImageRes(R.mipmap.ic_launcher_round);
            rightRecyclerViewData.add(rightRecyclerViewBean);
        }
    }

    private void initItem2() {
        for (int i = 0; i < 140; i++) {
            item1.add("Item2\t" + i);
//            rightRecyclerViewBean
        }


    }

    private void initItem1() {
        for (int i = 0; i < 140; i++) {
            item1.add("Item1\t" + i);
        }
    }

    @Override
    public void initListener() {

    }

}
