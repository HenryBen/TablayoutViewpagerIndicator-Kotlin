package com.i3ni.geeknum1.bean

import java.io.Serializable
import java.util.ArrayList

/**
 * Created by Mustang on 19/4/30.
 *
 */
class TabBeanList : Serializable {
    var list = ArrayList<TabBean>()

    companion object {
        private const val serialVersionUID = -7060210544600464481L
    }
}
