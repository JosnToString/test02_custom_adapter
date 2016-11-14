package com.example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Json on 2016/11/14.
 */

public abstract class CommonAdapter<T> extends BaseAdapter {

    public LayoutInflater minflater;

    public Context mContext;

    public List<T> mDatas;

    public int itemLayoutId;

    public CommonAdapter(Context context,List<T> mDatas,int itemLayoutId) {
        minflater = LayoutInflater.from(context);
        this.mDatas = mDatas;
        this.mContext = context;
        this.itemLayoutId = itemLayoutId;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder = getViewHolder(position,convertView,parent);

        convert(viewHolder,getItem(position));


        return viewHolder.getConvertView();
    }

    protected abstract void convert(ViewHolder viewHoler,T item);


    private ViewHolder getViewHolder(int position,View convertView,ViewGroup parent){

        return  ViewHolder.get(convertView,mContext,itemLayoutId,parent,position);
    }

}