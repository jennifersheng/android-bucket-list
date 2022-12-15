package edu.virginia.cs4720.bucketlist.jss8ny;

import java.lang.System;

@androidx.room.TypeConverters(value = {edu.virginia.cs4720.bucketlist.jss8ny.BucketListConverters.class})
@androidx.room.Database(entities = {edu.virginia.cs4720.bucketlist.jss8ny.BucketListItem.class}, version = 1, exportSchema = true)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Ledu/virginia/cs4720/bucketlist/jss8ny/BucketListDatabase;", "Landroidx/room/RoomDatabase;", "()V", "bucketListDao", "Ledu/virginia/cs4720/bucketlist/jss8ny/BucketListDao;", "Companion", "app_debug"})
public abstract class BucketListDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final edu.virginia.cs4720.bucketlist.jss8ny.BucketListDatabase.Companion Companion = null;
    @kotlin.jvm.Volatile()
    private static volatile edu.virginia.cs4720.bucketlist.jss8ny.BucketListDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    private static final edu.virginia.cs4720.bucketlist.jss8ny.BucketListItem fdocPic = null;
    @org.jetbrains.annotations.NotNull()
    private static final edu.virginia.cs4720.bucketlist.jss8ny.BucketListItem cartersMtn = null;
    @org.jetbrains.annotations.NotNull()
    private static final edu.virginia.cs4720.bucketlist.jss8ny.BucketListItem bodos = null;
    @org.jetbrains.annotations.NotNull()
    private static final edu.virginia.cs4720.bucketlist.jss8ny.BucketListItem lightingLawn = null;
    @org.jetbrains.annotations.NotNull()
    private static final edu.virginia.cs4720.bucketlist.jss8ny.BucketListItem springBreak = null;
    @org.jetbrains.annotations.NotNull()
    private static final edu.virginia.cs4720.bucketlist.jss8ny.BucketListItem graduate = null;
    
    public BucketListDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract edu.virginia.cs4720.bucketlist.jss8ny.BucketListDao bucketListDao();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0011\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\b\u00a8\u0006\u0017"}, d2 = {"Ledu/virginia/cs4720/bucketlist/jss8ny/BucketListDatabase$Companion;", "", "()V", "INSTANCE", "Ledu/virginia/cs4720/bucketlist/jss8ny/BucketListDatabase;", "bodos", "Ledu/virginia/cs4720/bucketlist/jss8ny/BucketListItem;", "getBodos", "()Ledu/virginia/cs4720/bucketlist/jss8ny/BucketListItem;", "cartersMtn", "getCartersMtn", "fdocPic", "getFdocPic", "graduate", "getGraduate", "lightingLawn", "getLightingLawn", "springBreak", "getSpringBreak", "buildDatabase", "context", "Landroid/content/Context;", "getDatabase", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final edu.virginia.cs4720.bucketlist.jss8ny.BucketListDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private final edu.virginia.cs4720.bucketlist.jss8ny.BucketListDatabase buildDatabase(android.content.Context context) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final edu.virginia.cs4720.bucketlist.jss8ny.BucketListItem getFdocPic() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final edu.virginia.cs4720.bucketlist.jss8ny.BucketListItem getCartersMtn() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final edu.virginia.cs4720.bucketlist.jss8ny.BucketListItem getBodos() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final edu.virginia.cs4720.bucketlist.jss8ny.BucketListItem getLightingLawn() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final edu.virginia.cs4720.bucketlist.jss8ny.BucketListItem getSpringBreak() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final edu.virginia.cs4720.bucketlist.jss8ny.BucketListItem getGraduate() {
            return null;
        }
    }
}