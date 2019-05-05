package com.i3ni.geeknum1.view;


import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.i3ni.geeknum1.R;
import com.i3ni.geeknum1.bean.TabBean;

/**
 * Created by Mustang on 19/4/30.
 */

public abstract class BaseTabView extends LinearLayout {
    protected TabBean bean;


    public BaseTabView(Context context) {
        super(context);
    }

    public BaseTabView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseTabView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setData(TabBean bean) {
        this.bean = bean;
        initView();
    }

    public abstract void initView();


}

