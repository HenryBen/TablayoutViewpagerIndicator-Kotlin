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
import com.i3ni.geeknum1.fragment.TabFragment
import com.i3ni.geeknum1.bean.TabBeanList

import java.io.Serializable
import java.util.ArrayList

/**
 * Created by Mustang on 19/4/30.
 *
 */

class HomeTabsChangeView : LinearLayout {
    private var mViewpager: ViewPager? = null
    private var line: ViewPagerIndicator? = null
    private var adapter: ViewPagerAdapter? = null
    private val fragments = ArrayList<Fragment>()

    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView()
    }

    private fun initView() {
        val view = View.inflate(context,
                R.layout.view_home_tabs_change, this)
        mViewpager = view.findViewById<View>(R.id.viewpager) as ViewPager
        line = findViewById<View>(R.id.indicator_line) as ViewPagerIndicator
    }

    fun refresh(list: TabBeanList) {

        val size: Int
        if (list.list.size % TAB_PAGE_SIZE == 0) {
            size = list.list.size / TAB_PAGE_SIZE
        } else {
            size = list.list.size / TAB_PAGE_SIZE + 1
        }

        fragments.clear()
        for (i in 0 until size) {
            val newList = TabBeanList()
            val fragment = TabFragment()
            val bundle = Bundle()
            for (j in i * TAB_PAGE_SIZE until if ((i + 1) * TAB_PAGE_SIZE > list.list.size)
                list.list.size
            else
                (i + 1) * TAB_PAGE_SIZE) {
                newList.list.add(list.list[j])
            }
            bundle.putSerializable("tab_list", newList as Serializable)
            fragment.arguments = bundle
            fragments.add(fragment)
        }
        adapter = ViewPagerAdapter((context as FragmentActivity).supportFragmentManager,
                fragments)
        mViewpager!!.adapter = adapter
        mViewpager!!.currentItem = 0
        // adapter.notifyDataSetChanged();
        line!!.setViewPager(mViewpager!!)
    }

    internal inner class ViewPagerAdapter(supportFragmentManager: FragmentManager,
                                          private val mFragments: ArrayList<Fragment>) : FragmentStatePagerAdapter(supportFragmentManager) {

        override fun getItemPosition(`object`: Any): Int {
            return PagerAdapter.POSITION_NONE
        }

        override fun getItem(position: Int): Fragment {
            return mFragments[position]

        }

        override fun getCount(): Int {
            return mFragments.size
        }
    }

    companion object {
        private val TAB_PAGE_SIZE = 4
    }


}

