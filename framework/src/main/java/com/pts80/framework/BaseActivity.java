package com.pts80.framework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Activity基类
 * Created by VichanHo on 2016/9/2.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutResID());
        initViews();
        initDatas();
        initEvent();
    }

    public abstract int setLayoutResID();

    public abstract void initViews();

    public abstract void initDatas();

    public abstract void initEvent();
}
