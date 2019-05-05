package com.i3ni.geeknum1.view;


import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.i3ni.geeknum1.R;
import com.i3ni.geeknum1.bean.TabBean;

/**
 * Created by Mustang on 19/4/30.
 *
 */

public class RecordView extends BaseTabView {


    public RecordView(Context context) {
        super(context);
    }

    public RecordView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RecordView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void initView() {
        View view = inflate(getContext(),
                R.layout.view_record, this);
        view.findViewById(R.id.tv_test).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"测试额度",Toast.LENGTH_LONG).show();
            }
        });
    }


}

