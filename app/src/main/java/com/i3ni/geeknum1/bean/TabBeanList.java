package com.i3ni.geeknum1.bean;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Created by Mustang on 19/4/30.
 *
 */
public class TabBeanList implements Serializable {
    private static final long serialVersionUID = -7060210544600464481L;
    ArrayList<TabBean> mList = new ArrayList<>();

    public ArrayList<TabBean> getList() {
        return mList;
    }

    public void setList(ArrayList<TabBean> list) {
        mList = list;
    }
}
