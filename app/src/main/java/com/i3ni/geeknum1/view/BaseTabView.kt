package com.i3ni.geeknum1.view


import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout

import com.i3ni.geeknum1.R
import com.i3ni.geeknum1.bean.TabBean

/**
 * Created by Mustang on 19/4/30.
 */

abstract class BaseTabView : LinearLayout {
    protected lateinit var bean: TabBean


    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    fun setData(bean: TabBean) {
        this.bean = bean
        initView()
    }

    abstract fun initView()


}

