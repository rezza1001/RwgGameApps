package com.rezza.rwggameapps.base;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class MyActivity extends AppCompatActivity {

    protected String TAG = "MyActivity";
    protected Activity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        mActivity = this;

        TAG = mActivity.getClass().getSimpleName();

        initLayout();
        initData();
        initListener();
    }


    protected abstract int setLayout();
    protected abstract void initLayout();
    protected abstract void initData();
    protected abstract void initListener();


}
