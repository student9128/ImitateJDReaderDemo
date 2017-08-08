package com.tech.kevin.imitatejdreaderdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/6/30 23:37.
 * <div>Blog: http://blog.csdn.net/student9128.</div>
 * <h3>Description:</h3>
 * <p/>
 * <p/>
 */


public abstract class BaseActivity extends AppCompatActivity {
    /**
     * Tag,that can be used for log or toast.
     */
    public String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutResId());
        ButterKnife.bind(this);
        initView();
        initData();
        initListener();
    }

    protected abstract int setLayoutResId();


    public abstract void initView();

    public abstract void initData();

    public abstract void initListener();

    /**
     * get the text from string
     *
     * @param ResId
     * @return
     */
    public String getMyString(int ResId) {
        return getResources().getString(ResId);
    }

    /**
     * can be used for setting text color or background
     *
     * @param colorId
     * @return
     */
    public int getMyColor(int colorId) {
        return ContextCompat.getColor(this, colorId);
    }

    public void showToast(String message) {
        ToastUtils.showToast(this, message);
    }

    public void showLongToast(String message) {
        ToastUtils.showLongToast(this, message);
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
