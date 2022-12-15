package edu.virginia.cs4720.bucketlist.jss8ny;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\tH\'J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0019\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Ledu/virginia/cs4720/bucketlist/jss8ny/BucketListDao;", "", "addBucketListItem", "", "bucketListItem", "Ledu/virginia/cs4720/bucketlist/jss8ny/BucketListItem;", "(Ledu/virginia/cs4720/bucketlist/jss8ny/BucketListItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketListItem", "getBucketList", "Lkotlinx/coroutines/flow/Flow;", "", "insertBucketListItem", "updateBucketListItem", "app_debug"})
public abstract interface BucketListDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract java.lang.Object addBucketListItem(@org.jetbrains.annotations.NotNull()
    edu.virginia.cs4720.bucketlist.jss8ny.BucketListItem bucketListItem, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @androidx.room.Insert()
    public abstract void insertBucketListItem(@org.jetbrains.annotations.NotNull()
    edu.virginia.cs4720.bucketlist.jss8ny.BucketListItem bucketListItem);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM bucketList_table ORDER BY complete, (CASE complete WHEN 0 THEN dueDate END) ASC, (CASE complete WHEN 1 THEN completeDate END) DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<edu.virginia.cs4720.bucketlist.jss8ny.BucketListItem>> getBucketList();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update()
    public abstract java.lang.Object updateBucketListItem(@org.jetbrains.annotations.NotNull()
    edu.virginia.cs4720.bucketlist.jss8ny.BucketListItem bucketListItem, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object deleteBucketListItem(@org.jetbrains.annotations.NotNull()
    edu.virginia.cs4720.bucketlist.jss8ny.BucketListItem bucketListItem, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}