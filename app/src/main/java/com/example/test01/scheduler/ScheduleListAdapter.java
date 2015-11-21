package com.example.test01.scheduler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class ScheduleListAdapter extends BaseAdapter {

    private Context mContext;

    private List<ScheduleListItem> mItems = new ArrayList<ScheduleListItem>();

    public ScheduleListAdapter(Context context) {
        mContext = context;
    }

    public void clear() {
        mItems.clear();
    }

    public void addItem(ScheduleListItem it) { mItems.add(it); }

    public int getCount() {
        return mItems.size();
    }

    public Object getItem(int position) {
        return mItems.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        ScheduleListItemView itemView;
        if (convertView == null){

            itemView = new ScheduleListItemView(mContext);
        } else {

            itemView = (ScheduleListItemView) convertView;
        }

        itemView.setContents(0, ((String) mItems.get(position).getData(1)));
        itemView.setContents(1, ((String) mItems.get(position).getData(2)));

        return itemView;

    }



}
