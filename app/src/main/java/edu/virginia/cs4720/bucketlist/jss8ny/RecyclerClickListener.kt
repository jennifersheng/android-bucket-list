package edu.virginia.cs4720.bucketlist.jss8ny

// Resources:
// https://johncodeos.com/how-to-use-room-in-android-using-kotlin/
// https://github.com/johncodeos-blog/RoomExample/
interface RecyclerClickListener {
    fun onItemRemoveClick(position: Int)
    fun onItemClick(position: Int)
    fun onItemCheckboxClick(position: Int)
    fun onItemCheckboxUnclick(position: Int)
}