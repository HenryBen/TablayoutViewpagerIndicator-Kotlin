package com.i3ni.geeknum1.view;


import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.i3ni.geeknum1.R;
import com.i3ni.geeknum1.bean.TabBean;

/**
 * Created by Mustang on 19/4/30.
 *
 */

public class TestView extends BaseTabView {


    public TestView(Context context) {
        super(context);

    }

    public TestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    public TestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    public void initView() {
        View view = inflate(getContext(),
                R.layout.view_test, this);
        TextView textView =  view.findViewById(R.id.tv);
        textView.setText(bean.getTabName());
    }


}

