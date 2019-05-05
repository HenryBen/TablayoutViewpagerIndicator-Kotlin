package com.i3ni.geeknum1.view;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.i3ni.geeknum1.R;
import com.i3ni.geeknum1.fragment.TabFragment;
import com.i3ni.geeknum1.bean.TabBeanList;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Mustang on 19/4/30.
 *
 */

public class HomeTabsChangeView extends LinearLayout {
    private final Context context;
    private ViewPager mViewpager;
    private ViewPagerIndicator line;
    private ViewPagerAdapter adapter;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private static final int TAB_PAGE_SIZE = 4;

    public HomeTabsChangeView(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    public HomeTabsChangeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
    }

    public HomeTabsChangeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView();
    }

    private void initView() {
        View view = inflate(context,
                R.layout.view_home_tabs_change, this);
        mViewpager = (ViewPager) view.findViewById(R.id.viewpager);
        line = (ViewPagerIndicator) findViewById(R.id.indicator_line);
    }

    public void refresh(TabBeanList list) {

        int size;
        if (list.getList().size() % TAB_PAGE_SIZE == 0) {
            size = list.getList().size() / TAB_PAGE_SIZE;
        } else {
            size = list.getList().size() / TAB_PAGE_SIZE + 1;
        }

        fragments.clear();
        for (int i = 0; i < size; i++) {
            TabBeanList newList = new TabBeanList();
            TabFragment fragment = new TabFragment();
            Bundle bundle = new Bundle();
            for (int j = i * TAB_PAGE_SIZE; j < ((i + 1) * TAB_PAGE_SIZE > list.getList().size()
                    ? list.getList().size()
                    : (i + 1) * TAB_PAGE_SIZE); j++) {
                newList.getList().add(list.getList().get(j));
            }
            bundle.putSerializable("tab_list", (Serializable) newList);
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        adapter = new ViewPagerAdapter(((FragmentActivity) context).getSupportFragmentManager(),
                fragments);
        mViewpager.setAdapter(adapter);
        mViewpager.setCurrentItem(0);
        // adapter.notifyDataSetChanged();
        line.setViewPager(mViewpager);
    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter {


        private ArrayList<Fragment> mFragments;


        public ViewPagerAdapter(FragmentManager supportFragmentManager,
                                ArrayList<Fragment> fragments) {
            super(supportFragmentManager);
            mFragments = fragments;

        }

        @Override
        public int getItemPosition(Object object) {
            return PagerAdapter.POSITION_NONE;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);

        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }


}

