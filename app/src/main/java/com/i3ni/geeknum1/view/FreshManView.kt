package com.i3ni.geeknum1.view


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout

import com.i3ni.geeknum1.R
import com.i3ni.geeknum1.bean.TabBean
import com.i3ni.geeknum1.bean.TabBeanList
import com.i3ni.geeknum1.fragment.TabFragment

import java.io.Serializable
import java.util.ArrayList

/**
 * Created by Mustang on 19/4/30.
 *
 */

class FreshManView : BaseTabView {


    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun initView() {
         View.inflate(context,
                R.layout.view_freshman, this)
    }


}

