package com.byjus.news.view.base;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Generic Base adapter for recycler views
 * <p>
 */
public abstract class BaseAdapter<T extends RecyclerView.ViewHolder, D> extends RecyclerView.Adapter<T>{

    public abstract void setData(List<D> data);
}