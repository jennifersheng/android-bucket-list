package edu.virginia.cs4720.bucketlist.jss8ny;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class BucketListDao_Impl implements BucketListDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<BucketListItem> __insertionAdapterOfBucketListItem;

  private final EntityInsertionAdapter<BucketListItem> __insertionAdapterOfBucketListItem_1;

  private final EntityDeletionOrUpdateAdapter<BucketListItem> __deletionAdapterOfBucketListItem;

  private final EntityDeletionOrUpdateAdapter<BucketListItem> __updateAdapterOfBucketListItem;

  public BucketListDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBucketListItem = new EntityInsertionAdapter<BucketListItem>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `bucketList_table` (`createDate`,`itemText`,`dueDate`,`complete`,`completeDate`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BucketListItem value) {
        if (value.getCreateDate() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCreateDate());
        }
        if (value.getItemText() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getItemText());
        }
        if (value.getDueDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getDueDate());
        }
        final int _tmp = value.getComplete() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        if (value.getCompleteDate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getCompleteDate());
        }
      }
    };
    this.__insertionAdapterOfBucketListItem_1 = new EntityInsertionAdapter<BucketListItem>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `bucketList_table` (`createDate`,`itemText`,`dueDate`,`complete`,`completeDate`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BucketListItem value) {
        if (value.getCreateDate() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCreateDate());
        }
        if (value.getItemText() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getItemText());
        }
        if (value.getDueDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getDueDate());
        }
        final int _tmp = value.getComplete() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        if (value.getCompleteDate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getCompleteDate());
        }
      }
    };
    this.__deletionAdapterOfBucketListItem = new EntityDeletionOrUpdateAdapter<BucketListItem>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `bucketList_table` WHERE `createDate` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BucketListItem value) {
        if (value.getCreateDate() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCreateDate());
        }
      }
    };
    this.__updateAdapterOfBucketListItem = new EntityDeletionOrUpdateAdapter<BucketListItem>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `bucketList_table` SET `createDate` = ?,`itemText` = ?,`dueDate` = ?,`complete` = ?,`completeDate` = ? WHERE `createDate` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BucketListItem value) {
        if (value.getCreateDate() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCreateDate());
        }
        if (value.getItemText() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getItemText());
        }
        if (value.getDueDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getDueDate());
        }
        final int _tmp = value.getComplete() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        if (value.getCompleteDate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getCompleteDate());
        }
        if (value.getCreateDate() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getCreateDate());
        }
      }
    };
  }

  @Override
  public Object addBucketListItem(final BucketListItem bucketListItem,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfBucketListItem.insert(bucketListItem);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public void insertBucketListItem(final BucketListItem bucketListItem) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfBucketListItem_1.insert(bucketListItem);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Object deleteBucketListItem(final BucketListItem bucketListItem,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfBucketListItem.handle(bucketListItem);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateBucketListItem(final BucketListItem bucketListItem,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfBucketListItem.handle(bucketListItem);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<BucketListItem>> getBucketList() {
    final String _sql = "SELECT * FROM bucketList_table ORDER BY complete, (CASE complete WHEN 0 THEN dueDate END) ASC, (CASE complete WHEN 1 THEN completeDate END) DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"bucketList_table"}, new Callable<List<BucketListItem>>() {
      @Override
      public List<BucketListItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCreateDate = CursorUtil.getColumnIndexOrThrow(_cursor, "createDate");
          final int _cursorIndexOfItemText = CursorUtil.getColumnIndexOrThrow(_cursor, "itemText");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfComplete = CursorUtil.getColumnIndexOrThrow(_cursor, "complete");
          final int _cursorIndexOfCompleteDate = CursorUtil.getColumnIndexOrThrow(_cursor, "completeDate");
          final List<BucketListItem> _result = new ArrayList<BucketListItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final BucketListItem _item;
            final Long _tmpCreateDate;
            if (_cursor.isNull(_cursorIndexOfCreateDate)) {
              _tmpCreateDate = null;
            } else {
              _tmpCreateDate = _cursor.getLong(_cursorIndexOfCreateDate);
            }
            final String _tmpItemText;
            if (_cursor.isNull(_cursorIndexOfItemText)) {
              _tmpItemText = null;
            } else {
              _tmpItemText = _cursor.getString(_cursorIndexOfItemText);
            }
            final Long _tmpDueDate;
            if (_cursor.isNull(_cursorIndexOfDueDate)) {
              _tmpDueDate = null;
            } else {
              _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
            }
            final boolean _tmpComplete;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfComplete);
            _tmpComplete = _tmp != 0;
            final Long _tmpCompleteDate;
            if (_cursor.isNull(_cursorIndexOfCompleteDate)) {
              _tmpCompleteDate = null;
            } else {
              _tmpCompleteDate = _cursor.getLong(_cursorIndexOfCompleteDate);
            }
            _item = new BucketListItem(_tmpCreateDate,_tmpItemText,_tmpDueDate,_tmpComplete,_tmpCompleteDate);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
