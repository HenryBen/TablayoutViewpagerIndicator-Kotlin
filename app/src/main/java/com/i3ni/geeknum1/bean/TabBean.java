package com.i3ni.geeknum1.bean;

import java.io.Serializable;
/**
 * Created by Mustang on 19/4/30.
 *
 */
public class TabBean implements Serializable {
    private static final long serialVersionUID = -7060210544600484481L;
    public TabBean(String tabName, int imageSrc, int tagNumber) {
        this.tabName = tabName;
        this.imageSrc = imageSrc;
        this.tagNumber = tagNumber;
    }

    private String tabName;
    private int imageSrc;

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public int getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(int imageSrc) {
        this.imageSrc = imageSrc;
    }

    public int getTagNumber() {
        return tagNumber;
    }

    public void setTagNumber(int tagNumber) {
        this.tagNumber = tagNumber;
    }

    private int tagNumber;
}
