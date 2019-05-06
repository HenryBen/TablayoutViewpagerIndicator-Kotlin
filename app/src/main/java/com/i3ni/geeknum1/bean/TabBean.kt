package com.i3ni.geeknum1.bean

import java.io.Serializable

/**
 * Created by Mustang on 19/4/30.
 *
 */
class TabBean(var tabName: String?, var imageSrc: Int, var tagNumber: Int) : Serializable {
    companion object {
        private const val serialVersionUID = -7060210544600484481L
    }
}
