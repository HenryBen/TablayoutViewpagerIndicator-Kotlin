package com.i3ni.geeknum1.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.i3ni.geeknum1.R;
import com.i3ni.geeknum1.bean.TabBean;
import com.i3ni.geeknum1.bean.TabBeanList;
import com.i3ni.geeknum1.view.HomeTabsChangeView;

/**
 * Created by Mustang on 19/4/30.
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final HomeTabsChangeView homeTabsChangeView =
                (HomeTabsChangeView) findViewById(R.id.home_tab);
        Button bt = (Button) findViewById(R.id.bt);
        final TabBeanList list = new TabBeanList();
        TabBean bean1 = new TabBean("设提醒", R.mipmap.p1, 11);
        TabBean bean2 = new TabBean("卡券包", R.mipmap.p2, 0);
        TabBean bean3 = new TabBean("查记录", R.mipmap.p3, 0);
        TabBean bean4 = new TabBean("邀好友", R.mipmap.p4, 0);
        TabBean bean5 = new TabBean("新手礼", R.mipmap.p5, 0);
        TabBean bean6 = new TabBean("去提额", R.mipmap.p6, 21);
        TabBean bean7 = new TabBean("去还款", R.mipmap.p7, 0);
        TabBean bean8 = new TabBean("去设置", R.mipmap.p8, 0);
        TabBean bean9 = new TabBean("去贷款", R.mipmap.p9, 31);
        list.getList().add(bean1);
        list.getList().add(bean2);
        list.getList().add(bean3);
        list.getList().add(bean4);
        list.getList().add(bean5);
        list.getList().add(bean6);
        list.getList().add(bean7);
        list.getList().add(bean8);
        homeTabsChangeView.refresh(list);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabBeanList list = new TabBeanList();
                TabBean bean1 = new TabBean("设提醒", R.mipmap.p1, 11);
                TabBean bean2 = new TabBean("卡券包", R.mipmap.p2, 0);
                TabBean bean3 = new TabBean("查记录", R.mipmap.p3, 0);
                TabBean bean4 = new TabBean("邀好友", R.mipmap.p4, 0);
                TabBean bean5 = new TabBean("新手礼", R.mipmap.p5, 0);
                TabBean bean6 = new TabBean("去提额", R.mipmap.p6, 21);
                TabBean bean7 = new TabBean("去还款", R.mipmap.p7, 0);
                TabBean bean8 = new TabBean("去设置", R.mipmap.p8, 0);
                TabBean bean9 = new TabBean("去贷款", R.mipmap.p9, 31);
                list.getList().add(bean5);
                list.getList().add(bean3);
                list.getList().add(bean2);
                list.getList().add(bean1);
                list.getList().add(bean4);
                list.getList().add(bean6);
                 list.getList().add(bean7);
                 //list.getList().add(bean8);
                homeTabsChangeView.refresh(list);
            }
        });
    }

}