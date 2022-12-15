package edu.virginia.cs4720.bucketlist.jss8ny;

import java.lang.System;

@androidx.room.Entity(tableName = "bucketList_table")
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u0017\u001a\u00020\bH\u00c6\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJF\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0005H\u00d6\u0001R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006 "}, d2 = {"Ledu/virginia/cs4720/bucketlist/jss8ny/BucketListItem;", "", "createDate", "", "itemText", "", "dueDate", "complete", "", "completeDate", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;ZLjava/lang/Long;)V", "getComplete", "()Z", "getCompleteDate", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCreateDate", "getDueDate", "getItemText", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;ZLjava/lang/Long;)Ledu/virginia/cs4720/bucketlist/jss8ny/BucketListItem;", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class BucketListItem {
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "createDate")
    @androidx.room.PrimaryKey()
    private final java.lang.Long createDate = null;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "itemText")
    private final java.lang.String itemText = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "dueDate")
    private final java.lang.Long dueDate = null;
    @androidx.room.ColumnInfo(name = "complete")
    private final boolean complete = false;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "completeDate")
    private final java.lang.Long completeDate = null;
    
    @org.jetbrains.annotations.NotNull()
    public final edu.virginia.cs4720.bucketlist.jss8ny.BucketListItem copy(@org.jetbrains.annotations.Nullable()
    java.lang.Long createDate, @org.jetbrains.annotations.NotNull()
    java.lang.String itemText, @org.jetbrains.annotations.Nullable()
    java.lang.Long dueDate, boolean complete, @org.jetbrains.annotations.Nullable()
    java.lang.Long completeDate) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public BucketListItem(@org.jetbrains.annotations.Nullable()
    java.lang.Long createDate, @org.jetbrains.annotations.NotNull()
    java.lang.String itemText, @org.jetbrains.annotations.Nullable()
    java.lang.Long dueDate, boolean complete, @org.jetbrains.annotations.Nullable()
    java.lang.Long completeDate) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getCreateDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getItemText() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getDueDate() {
        return null;
    }
    
    public final boolean component4() {
        return false;
    }
    
    public final boolean getComplete() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getCompleteDate() {
        return null;
    }
}