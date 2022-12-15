package edu.virginia.cs4720.bucketlist.jss8ny

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import java.util.*

// Resources:
// https://johncodeos.com/how-to-use-room-in-android-using-kotlin/
// https://github.com/johncodeos-blog/RoomExample/
@Entity(tableName = "bucketList_table")
data class BucketListItem (
    @PrimaryKey
    @ColumnInfo(name = "createDate") val createDate: Long?,
    @ColumnInfo(name = "itemText") val itemText: String,
    @ColumnInfo(name = "dueDate") val dueDate: Long?,
    @ColumnInfo(name = "complete") val complete: Boolean,
    @ColumnInfo(name = "completeDate") val completeDate: Long?
)