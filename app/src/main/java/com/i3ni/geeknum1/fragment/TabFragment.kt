package com.i3ni.geeknum1.fragment


import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.i3ni.geeknum1.R
import com.i3ni.geeknum1.bean.TabBean
import com.i3ni.geeknum1.bean.TabBeanList
import kotlinx.android.synthetic.main.fragment_tab.*

import java.io.Serializable
import java.util.ArrayList


/**
 * Created by Mustang on 19/4/30.
 */
class TabFragment : Fragment() {


    private var adapter: TabAdapter? = null


    private val fragments = ArrayList<Fragment>()
    private var tabs = ArrayList<TabBean>()
    //定义选中的颜色
    private var checkColor: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_tab, container, false)
        val list = arguments!!.getSerializable("tab_list") as TabBeanList
        tabs = list.list
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initView()

    }


    private fun initData() {
        for (i in tabs.indices) {
            val tabFragment = TabItemFragment()
            val bundle = Bundle()
            bundle.putSerializable("tab_item", tabs[i] as Serializable)
            when (tabs[i].tabName) {
                "设置提醒" -> bundle.putInt("layout", R.layout.fragment_item_test)
                "卡券包" -> bundle.putInt("layout", R.layout.fragment_item_test)
                "查记录" -> bundle.putInt("layout", R.layout.fragment_item_record)
                "邀好友" -> bundle.putInt("layout", R.layout.fragment_item_test)
                "新手礼" -> bundle.putInt("layout", R.layout.fragment_item_freshman)
                "去提醒" -> bundle.putInt("layout", R.layout.fragment_item_test)
                "去还款" -> bundle.putInt("layout", R.layout.fragment_item_test)
                "去设置" -> bundle.putInt("layout", R.layout.fragment_item_test)
                else -> bundle.putInt("layout", R.layout.fragment_item_test)
            }

            tabFragment.arguments = bundle
            fragments.add(tabFragment)
        }

    }

    private fun initView() {
        //定义选中的颜色
        checkColor = resources.getColor(R.color.blue)
        //viewPager.setOffscreenPageLimit(3);
        setTabView()

    }

    /**
     * 设置Tab的样式
     */
    private fun setTabView() {
        for (i in tabs.indices) {
            val tab = tayLayout!!.newTab()
            tab.setCustomView(R.layout.tab_item)
            val tv_tab_name = tab.customView!!.findViewById(R.id.tv_tab_name) as TextView
            val tv_tag = tab.customView!!.findViewById(R.id.tv_tag) as TextView
            val image = tab.customView!!.findViewById(R.id.image) as ImageView
            tv_tab_name.text = tabs[i].tabName
            if (tabs[i].tagNumber == 0) {
                tv_tag.visibility = View.INVISIBLE
            } else {
                tv_tag.text = tabs[i].tagNumber.toString() + ""
                tv_tag.visibility = View.VISIBLE
            }

            image.setImageResource(tabs[i].imageSrc)
            //默认选择第一项
            if (i == 0) {
                tv_tab_name.setTextColor(checkColor)
                //当选中该项时，显示选中颜色，否则显示未选中颜色
                image.setColorFilter(checkColor)

            }
            tayLayout!!.addTab(tab)

        }

        adapter = TabAdapter(childFragmentManager)
        viewPager!!.adapter = adapter

        // tabLayout.setupWithViewPager(viewPager);


        tayLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
                if (tab.customView != null) {
                    val view = tab.customView
                    val tv_tab_name = view!!.findViewById<TextView>(R.id.tv_tab_name)
                    val mImage = view.findViewById<ImageView>(R.id.image)
                    tv_tab_name.setTextColor(checkColor)
                    //当选中该项时，显示选中颜色，否则显示未选中颜色
                    mImage.setColorFilter(checkColor)
                }
                //  viewPager.getAdapter().notifyDataSetChanged();

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                if (tab.customView != null) {
                    val view = tab.customView
                    val tv_tab_name = view!!.findViewById<TextView>(R.id.tv_tab_name)
                    tv_tab_name.setTextColor(Color.parseColor("#FFAAAAAA"))
                    val mImage = view.findViewById<ImageView>(R.id.image)
                    mImage.setColorFilter(Color.TRANSPARENT)
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
        viewPager!!.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float,
                                        positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                tayLayout!!.setScrollPosition(position, 0f, true)
                //adapter.notifyDataSetChanged();
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

    }


    internal inner class TabAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }


        override fun getCount(): Int {
            return tabs.size
        }

        override fun getItemPosition(`object`: Any): Int {
            return PagerAdapter.POSITION_NONE
        }


    }


}// Required empty public constructor
