package co.basic.androidjetpackskeleton.ui.newRelease

import java.text.FieldPosition

interface OnItemClickListener {

    fun <T> onItemClick(position: Int, data:T)

}