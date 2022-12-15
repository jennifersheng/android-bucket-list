package edu.virginia.cs4720.bucketlist.jss8ny;

import java.lang.System;

@android.annotation.SuppressLint(value = {"SimpleDateFormat"})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Ledu/virginia/cs4720/bucketlist/jss8ny/BucketListRVAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Ledu/virginia/cs4720/bucketlist/jss8ny/BucketListItem;", "Ledu/virginia/cs4720/bucketlist/jss8ny/BucketListRVAdapter$BucketListItemHolder;", "()V", "listener", "Ledu/virginia/cs4720/bucketlist/jss8ny/RecyclerClickListener;", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItemListener", "BucketListItemHolder", "DiffCallback", "app_debug"})
public final class BucketListRVAdapter extends androidx.recyclerview.widget.ListAdapter<edu.virginia.cs4720.bucketlist.jss8ny.BucketListItem, edu.virginia.cs4720.bucketlist.jss8ny.BucketListRVAdapter.BucketListItemHolder> {
    private edu.virginia.cs4720.bucketlist.jss8ny.RecyclerClickListener listener;
    
    public BucketListRVAdapter() {
        super(null);
    }
    
    public final void setItemListener(@org.jetbrains.annotations.NotNull()
    edu.virginia.cs4720.bucketlist.jss8ny.RecyclerClickListener listener) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public edu.virginia.cs4720.bucketlist.jss8ny.BucketListRVAdapter.BucketListItemHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    edu.virginia.cs4720.bucketlist.jss8ny.BucketListRVAdapter.BucketListItemHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Ledu/virginia/cs4720/bucketlist/jss8ny/BucketListRVAdapter$BucketListItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "app_debug"})
    public static final class BucketListItemHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public BucketListItemHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Ledu/virginia/cs4720/bucketlist/jss8ny/BucketListRVAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Ledu/virginia/cs4720/bucketlist/jss8ny/BucketListItem;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class DiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<edu.virginia.cs4720.bucketlist.jss8ny.BucketListItem> {
        
        public DiffCallback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        edu.virginia.cs4720.bucketlist.jss8ny.BucketListItem oldItem, @org.jetbrains.annotations.NotNull()
        edu.virginia.cs4720.bucketlist.jss8ny.BucketListItem newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        edu.virginia.cs4720.bucketlist.jss8ny.BucketListItem oldItem, @org.jetbrains.annotations.NotNull()
        edu.virginia.cs4720.bucketlist.jss8ny.BucketListItem newItem) {
            return false;
        }
    }
}