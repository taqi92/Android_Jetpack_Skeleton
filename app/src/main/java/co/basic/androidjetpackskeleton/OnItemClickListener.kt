package co.basic.androidjetpackskeleton

interface OnItemClickListener {

    fun <T> onItemClick(position: Int, data:T)

}