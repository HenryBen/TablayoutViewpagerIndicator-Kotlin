package com.i3ni.geeknum1.view


import android.content.Context
import android.util.AttributeSet
import android.view.View

import com.i3ni.geeknum1.R
import kotlinx.android.synthetic.main.view_test.view.*

/**
 * Created by Mustang on 19/4/30.
 *
 */

class TestView : BaseTabView {


    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun initView() {
        View.inflate(context,
                R.layout.view_test, this)
        tv.text = bean.tabName
    }


}

