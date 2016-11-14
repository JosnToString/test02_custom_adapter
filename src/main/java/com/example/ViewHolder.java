package com.example;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Json on 2016/11/11.
 */

public class ViewHolder {

    private final SparseArray<View> mViews;

    private View mConvertView;

    /**
     * 用于给mConvertView赋值 并标记mConvertView
     * @param context
     * @param layoutId
     * @param parent
     * @param position
     */
    private ViewHolder(Context context, int layoutId, ViewGroup parent, int position) {
        this.mViews = new SparseArray<>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);

        mConvertView.setTag(this);
    }

    /**
     * 返回一个ViewHolder  如果传来的convertView是空 就重新执行构造方法 返回一个ViewHolder
     * 如果传来的convertView不是空 就返回被标记的ViewHolder
     * @param convertView
     * @param context
     * @param layoutId
     * @param parent
     * @param position
     * @return
     */
    public static ViewHolder get(View convertView, Context context, int layoutId, ViewGroup parent, int position) {
        if (convertView == null) {
            return new ViewHolder(context, layoutId, parent, position);
        }
        return (ViewHolder) convertView.getTag();
    }


    /**
     * 返回一个
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);

        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;

    }


    public ViewHolder setText(int viewId,String text){
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public View getConvertView() {
        return mConvertView;
    }


}
