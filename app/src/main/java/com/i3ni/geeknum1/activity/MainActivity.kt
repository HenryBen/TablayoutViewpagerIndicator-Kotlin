package com.i3ni.geeknum1.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

import com.i3ni.geeknum1.R
import com.i3ni.geeknum1.bean.TabBean
import com.i3ni.geeknum1.bean.TabBeanList
import com.i3ni.geeknum1.view.HomeTabsChangeView
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Mustang on 19/4/30.
 *
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = TabBeanList()
        val bean1 = TabBean("设提醒", R.mipmap.p1, 11)
        val bean2 = TabBean("卡券包", R.mipmap.p2, 0)
        val bean3 = TabBean("查记录", R.mipmap.p3, 0)
        val bean4 = TabBean("邀好友", R.mipmap.p4, 0)
        val bean5 = TabBean("新手礼", R.mipmap.p5, 0)
        val bean6 = TabBean("去提额", R.mipmap.p6, 21)
        val bean7 = TabBean("去还款", R.mipmap.p7, 0)
        val bean8 = TabBean("去设置", R.mipmap.p8, 0)
        val bean9 = TabBean("去贷款", R.mipmap.p9, 31)
        list.list.add(bean1)
        list.list.add(bean2)
        list.list.add(bean3)
        list.list.add(bean4)
        list.list.add(bean5)
        list.list.add(bean6)
        list.list.add(bean7)
        list.list.add(bean8)
        home_tab.refresh(list)
        bt.setOnClickListener {
            val list = TabBeanList()
            val bean1 = TabBean("设提醒", R.mipmap.p1, 11)
            val bean2 = TabBean("卡券包", R.mipmap.p2, 0)
            val bean3 = TabBean("查记录", R.mipmap.p3, 0)
            val bean4 = TabBean("邀好友", R.mipmap.p4, 0)
            val bean5 = TabBean("新手礼", R.mipmap.p5, 0)
            val bean6 = TabBean("去提额", R.mipmap.p6, 21)
            val bean7 = TabBean("去还款", R.mipmap.p7, 0)
            val bean8 = TabBean("去设置", R.mipmap.p8, 0)
            val bean9 = TabBean("去贷款", R.mipmap.p9, 31)
            list.list.add(bean5)
            list.list.add(bean3)
            list.list.add(bean2)
            list.list.add(bean1)
            list.list.add(bean4)
            list.list.add(bean6)
            list.list.add(bean7)
            //list.getList().add(bean8);
            home_tab.refresh(list)
        }
    }

}