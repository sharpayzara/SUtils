package com.sloop.adapter.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * ListView 的通用适配器
 * Author: Sloop
 * Version: v1.0
 * Date: 2015/11/17
 * <ul type="disc">
 * <li><a href="http://www.sloop.icoc.cc"    target="_blank">作者网站</a>      </li>
 * <li><a href="http://weibo.com/5459430586" target="_blank">作者微博</a>      </li>
 * <li><a href="https://github.com/GcsSloop" target="_blank">作者GitHub</a>   </li>
 * </ul>
 */
public abstract class CommonAdapter<T> extends BaseAdapter {

    private LayoutInflater mInflater;
    private Context mContext;
    private List<T> mDatas;
    private int mLayoutId;

    /**
     * @param context  上下文
     * @param datas    数据集
     * @param layoutId 布局ID
     */
    public CommonAdapter(Context context, List<T> datas, int layoutId) {
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mDatas = datas;
        this.mLayoutId = layoutId;
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
        //实例化一个ViewHolder
        ViewHolder holder = ViewHolder.getInstance(mContext, convertView, parent, mLayoutId, position);
        //需要自定义的部分
        convert(holder, getItem(position));

        return holder.getConvertView();
    }

    /**
     * 需要处理的部分，在这里给View设置值
     *
     * @param holder ViewHolder
     * @param bean   数据集
     */
    public abstract void convert(ViewHolder holder, T bean);
}

