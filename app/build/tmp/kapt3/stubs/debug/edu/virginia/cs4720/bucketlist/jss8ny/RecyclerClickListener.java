package edu.virginia.cs4720.bucketlist.jss8ny;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\t"}, d2 = {"Ledu/virginia/cs4720/bucketlist/jss8ny/RecyclerClickListener;", "", "onItemCheckboxClick", "", "position", "", "onItemCheckboxUnclick", "onItemClick", "onItemRemoveClick", "app_debug"})
public abstract interface RecyclerClickListener {
    
    public abstract void onItemRemoveClick(int position);
    
    public abstract void onItemClick(int position);
    
    public abstract void onItemCheckboxClick(int position);
    
    public abstract void onItemCheckboxUnclick(int position);
}