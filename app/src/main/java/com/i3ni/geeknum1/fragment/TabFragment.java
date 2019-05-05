package com.i3ni.geeknum1.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.i3ni.geeknum1.R;
import com.i3ni.geeknum1.bean.TabBean;
import com.i3ni.geeknum1.bean.TabBeanList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Mustang on 19/4/30.
 */
public class TabFragment extends Fragment {


    private View view;
    private TabAdapter adapter;


    public TabFragment() {
        // Required empty public constructor

    }


    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<Fragment> fragments = new ArrayList<>();
    private ArrayList<TabBean> tabs = new ArrayList<>();
    //定义选中的颜色
    private int checkColor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tab, container, false);
        TabBeanList list = (TabBeanList) getArguments().getSerializable("tab_list");
        tabs = list.getList();
        this.view = root;
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView();

    }


    private void initData() {
        for (int i = 0; i < tabs.size(); i++) {
            TabItemFragment tabFragment = new TabItemFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("tab_item", (Serializable) tabs.get(i));
            switch (tabs.get(i).getTabName()){
                case "设置提醒":
                    bundle.putInt("layout", R.layout.fragment_item_test);
                    break;
                case "卡券包":
                    bundle.putInt("layout", R.layout.fragment_item_test);
                    break;
                case "查记录":
                    bundle.putInt("layout", R.layout.fragment_item_record);
                    break;
                case "邀好友":
                    bundle.putInt("layout", R.layout.fragment_item_test);
                    break;
                case "新手礼":
                    bundle.putInt("layout", R.layout.fragment_item_freshman);
                    break;
                case "去提醒":
                    bundle.putInt("layout", R.layout.fragment_item_test);
                    break;
                case "去还款":
                    bundle.putInt("layout", R.layout.fragment_item_test);
                    break;
                case "去设置":
                    bundle.putInt("layout", R.layout.fragment_item_test);
                    break;
               default:
                   bundle.putInt("layout", R.layout.fragment_item_test);
                   break;
            }

            tabFragment.setArguments(bundle);
            fragments.add(tabFragment);
        }

    }

    private void initView() {
        //定义选中的颜色
        checkColor = getResources().getColor(R.color.blue);
        tabLayout = (TabLayout) view.findViewById(R.id.tayLayout);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        //viewPager.setOffscreenPageLimit(3);
        setTabView();

    }

    /**
     * 设置Tab的样式
     */
    private void setTabView() {
        for (int i = 0; i < tabs.size(); i++) {
            TabLayout.Tab tab = tabLayout.newTab();
            tab.setCustomView(R.layout.tab_item);
            TextView tv_tab_title = tab.getCustomView().findViewById(R.id.tv_tab_name);
            TextView tvTag = (TextView) tab.getCustomView().findViewById(R.id.tag);
            ImageView mImage = (ImageView) tab.getCustomView().findViewById(R.id.image);
            tv_tab_title.setText(tabs.get(i).getTabName());
            if (tabs.get(i).getTagNumber() == 0) {
                tvTag.setVisibility(View.INVISIBLE);
            } else {
                tvTag.setText(tabs.get(i).getTagNumber() + "");
                tvTag.setVisibility(View.VISIBLE);
            }

            mImage.setImageResource(tabs.get(i).getImageSrc());
            //默认选择第一项
            if (i == 0) {
                tv_tab_title.setTextColor(checkColor);
                //当选中该项时，显示选中颜色，否则显示未选中颜色
                mImage.setColorFilter(checkColor);

            }
            tabLayout.addTab(tab);

        }

        adapter = new TabAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);

        // tabLayout.setupWithViewPager(viewPager);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getCustomView() != null) {
                    View view = tab.getCustomView();
                    TextView tv_tab_name = view.findViewById(R.id.tv_tab_name);
                    ImageView mImage = view.findViewById(R.id.image);
                    tv_tab_name.setTextColor(checkColor);
                    //当选中该项时，显示选中颜色，否则显示未选中颜色
                    mImage.setColorFilter(checkColor);
                }
                //  viewPager.getAdapter().notifyDataSetChanged();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab.getCustomView() != null) {
                    View view = tab.getCustomView();
                    TextView tv_tab_name = view.findViewById(R.id.tv_tab_name);
                    tv_tab_name.setTextColor(Color.parseColor("#FFAAAAAA"));
                    ImageView mImage = view.findViewById(R.id.image);
                    mImage.setColorFilter(Color.TRANSPARENT);
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabLayout.setScrollPosition(position, 0f, true);
                //adapter.notifyDataSetChanged();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    class TabAdapter extends FragmentStatePagerAdapter {

        public TabAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }


        @Override
        public int getCount() {
            return tabs.size();
        }

        @Override
        public int getItemPosition(Object object) {
            return PagerAdapter.POSITION_NONE;
        }


    }


}
