package com.tech.kevin.imitatejdreaderdemo;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.btn_method_one)
    Button btnMethodOne;
    @BindView(R.id.btn_method_three)
    Button btnMethodThree;

    @Override
    protected int setLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        btnMethodOne.setOnClickListener(this);
        btnMethodThree.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_method_one:
                startActivity(new Intent(this, MultiFragmentActivity.class));
                break;
            case R.id.btn_method_three:
                startActivity(new Intent(this, RecyclerViewActivity.class));
                break;
        }
    }
}
