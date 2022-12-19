package com.rezza.rwggameapps.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.rezza.rwggameapps.R;

import java.util.Objects;

public abstract class MyDialog extends Dialog {

    protected Activity mActivity;
    protected View mView;

    public MyDialog(@NonNull Context context) {
        super(context, R.style.AppTheme_transparent);

        WindowManager.LayoutParams wlmp = Objects.requireNonNull(getWindow()).getAttributes();
        wlmp.gravity = Gravity.CENTER_HORIZONTAL;
        getWindow().setAttributes(wlmp);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        setTitle(null);
        setCancelable(false);
        setOnCancelListener(null);
        mActivity = (Activity) context;

        View view = LayoutInflater.from(context).inflate(setLayout(), null);
        setContentView(view);
        mView = view;
        setTransparent();
        initLayout(view);
    }

    protected void setTransparent(){
        Objects.requireNonNull(getWindow()).setStatusBarColor(Color.parseColor("#00ffffff"));
    }

    protected View getView(){
        return mView;
    }


    @Override
    public void show() {
        super.show();
    }

    protected abstract int setLayout();
    protected abstract void initLayout(View view);

}
