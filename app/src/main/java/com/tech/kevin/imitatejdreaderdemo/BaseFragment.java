package com.tech.kevin.imitatejdreaderdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/6/30 23:51.
 * <div>Blog: http://blog.csdn.net/student9128.</div>
 * <h3>Description:</h3>
 * <p/>
 * <p/>
 */


public abstract class BaseFragment extends Fragment {
    /**
     * Tag,that can be used for log or toast.
     */
    public String TAG = getClass().getSimpleName();
    /**
     * can be prevent nullPointer.
     */
    protected FragmentActivity mActivity;
    protected View mView;
    public Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(setLayoutResId(), container, false);
        ButterKnife.bind(this, mView);
        unbinder = ButterKnife.bind(this, mView);
        initView();
        initData();
        initListener();
        printLogi("onCreateVew");
        return mView;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = getActivity();
    }

    @Override
    public void onStart() {
        super.onStart();
//        refreshUI();
        printLogi("onStart");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        printLogi("onCreate");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        printLogi("onActivityCreated");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * set Layout Resource Id
     *
     * @return
     */
    public abstract int setLayoutResId();

    public abstract void initView();

    public abstract void initData();

    public abstract void initListener();

    public void showToast(String message) {
        ToastUtils.showToast(mActivity, message);
    }

    public void showLongToast(String message) {
        ToastUtils.showLongToast(mActivity, message);
    }

    public void printLoge(String str) {
        LogK.e(TAG, str);
    }

    public void printLogd(String str) {
        LogK.d(TAG, str);
    }

    public void printLogi(String str) {
        LogK.i(TAG, str);
    }

    public void printLogv(String str) {
        LogK.v(TAG, str);
    }

    public void printLogw(String str) {
        LogK.w(TAG, str);
    }

}
