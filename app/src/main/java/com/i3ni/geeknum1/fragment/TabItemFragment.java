package com.i3ni.geeknum1.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.i3ni.geeknum1.R;
import com.i3ni.geeknum1.bean.TabBean;
import com.i3ni.geeknum1.view.BaseTabView;

/**
 * Created by Mustang on 19/4/30.
 */

public class TabItemFragment extends Fragment {

    public TabItemFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        int layout = getArguments().getInt("layout");
        View root = inflater.inflate(layout, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TabBean bean = (TabBean) getArguments().getSerializable("tab_item");
        BaseTabView baseTabView = view.findViewById(R.id.item);
        baseTabView.setData(bean);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

    }
}
