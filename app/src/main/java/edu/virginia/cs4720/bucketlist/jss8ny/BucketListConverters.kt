package edu.virginia.cs4720.bucketlist.jss8ny

// Resources:
// https://stackoverflow.com/questions/67108957/how-to-create-a-typeconverter-that-converts-localdate-to-format-that-room-can-un
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.util.*

class BucketListConverters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

//    @TypeConverter
//    fun fromTimestamp(value: Long?): LocalDate? {
//        return value?.let { LocalDate.ofEpochDay(it) }
//    }
//
//    @TypeConverter
//    fun dateToTimestamp(date: LocalDate?): Long? {
//        val zoneId = ZoneId.systemDefault()
//        return date?.atStartOfDay(zoneId)?.toEpochSecond()
//    }
}