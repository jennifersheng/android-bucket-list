package edu.virginia.cs4720.bucketlist.jss8ny

// Resources:
// https://johncodeos.com/how-to-use-room-in-android-using-kotlin/
// https://github.com/johncodeos-blog/RoomExample/
import android.content.Context
import androidx.room.*
import androidx.sqlite.db.*
import java.util.*
//import androidx.lifecycle

@Database(entities = [BucketListItem::class], version = 1, exportSchema = true)
@TypeConverters(BucketListConverters::class)
public abstract class BucketListDatabase : RoomDatabase() {
    abstract fun bucketListDao(): BucketListDao

    companion object {
        @Volatile
        private var INSTANCE: BucketListDatabase? = null

        fun getDatabase(context: Context): BucketListDatabase {
            // if instance is not null, then return it
            // if it is, then create the databse
            if (INSTANCE == null) {
                synchronized(this) {
                    // Pass the database to the INSTANCE
                    INSTANCE = buildDatabase(context)
                }
            }
            // Return database
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                BucketListDatabase::class.java,
                "bucket_list_database"
            )
                // Reference:
                // https://gist.github.com/florina-muntenescu/697e543652b03d3d2a06703f5d6b44b5

                // Prepopulate data
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        // insert the data on the IO Thread
                        ioThread {
                            getDatabase(context).bucketListDao().insertBucketListItem(fdocPic)
                            getDatabase(context).bucketListDao().insertBucketListItem(cartersMtn)
                            getDatabase(context).bucketListDao().insertBucketListItem(bodos)
                            getDatabase(context).bucketListDao().insertBucketListItem(lightingLawn)
                            getDatabase(context).bucketListDao().insertBucketListItem(springBreak)
                            getDatabase(context).bucketListDao().insertBucketListItem(graduate)
                        }
                    }
                })
                .build()

            val fdocPic = BucketListItem(Date().time, "Take an FDOC picture", GregorianCalendar(2022,7,23,23,59,59).timeInMillis, false, 0)
            val cartersMtn = BucketListItem(Date().time+1, "Attend Sunset Series at Carters Mountain", GregorianCalendar(2022,8,29,23,59,59).timeInMillis, true, GregorianCalendar(2022,8,15).timeInMillis)
            val bodos = BucketListItem(Date().time+2, "Get the #1 ticket at Bodos", GregorianCalendar(2023,4,19,23,59,59).timeInMillis, true, GregorianCalendar(2022,9,4).timeInMillis)
            val lightingLawn = BucketListItem(Date().time+3, "Celebrate the holidays by going to Lighting of the Lawn", GregorianCalendar(2022,11,8,23,59,59).timeInMillis, false, 0)
            val springBreak = BucketListItem(Date().time+4, "Plan a getaway with friends for Spring Break", GregorianCalendar(2023,2,6,23,59,59).timeInMillis, false, 0)
            val graduate = BucketListItem(Date().time+5, "Wear the Honors of Honor", GregorianCalendar(2023,4,19,23,59,59).timeInMillis, false, 0)

//            val PREPOPULATE_DATA = listOf(BucketListItem(Date().time, "Attend Sunset Series at Carters Mountain", GregorianCalendar(2022+1900,8,29).timeInMillis, true, 0),
//                    BucketListItem(Date().time, "Celebrate the holidays by going to Lighting of the Lawn", GregorianCalendar(2022+1900,10,8).timeInMillis, false, 0),
//                    BucketListItem(Date().time, "Attend Sunset Series at Carters Mountain", GregorianCalendar(2023+1900,2,6).timeInMillis, false, 0),
//                    BucketListItem(Date().time, "Attend Sunset Series at Carters Mountain", GregorianCalendar(2023+1900,4,19).timeInMillis, false, 0)
//                )
    }
}