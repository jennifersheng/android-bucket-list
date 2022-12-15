package edu.virginia.cs4720.bucketlist.jss8ny

import androidx.room.*
import kotlinx.coroutines.flow.Flow

// Resources:
// https://johncodeos.com/how-to-use-room-in-android-using-kotlin/
// https://github.com/johncodeos-blog/RoomExample/
@Dao
interface BucketListDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addBucketListItem(bucketListItem: BucketListItem)

    @Insert
    fun insertBucketListItem(bucketListItem: BucketListItem)

    // Reference:
    // https://www.sqlitetutorial.net/sqlite-case/
    // https://stackoverflow.com/questions/25949837/case-statement-for-order-by-clause-with-desc-asc-sort
    @Query("SELECT * FROM bucketList_table ORDER BY complete, (CASE complete WHEN 0 THEN dueDate END) ASC, (CASE complete WHEN 1 THEN completeDate END) DESC")
    fun getBucketList(): Flow<List<BucketListItem>>

    @Update
    suspend fun updateBucketListItem(bucketListItem: BucketListItem)

    @Delete
    suspend fun deleteBucketListItem(bucketListItem: BucketListItem)

}