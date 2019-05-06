package com.i3ni.geeknum1.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.i3ni.geeknum1.R

import com.i3ni.geeknum1.bean.TabBean
import com.i3ni.geeknum1.view.BaseTabView

/**
 * Created by Mustang on 19/4/30.
 */

class TabItemFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val layout = arguments!!.getInt("layout")
        return inflater.inflate(layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bean = arguments!!.getSerializable("tab_item") as TabBean
        val baseTabView = view.findViewById<BaseTabView>(R.id.item)
        baseTabView.setData(bean)
    }


}
