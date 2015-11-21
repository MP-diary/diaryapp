package com.example.test01.scheduler;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by SOYOUNG on 2015-11-15.
 */
public class ScheduleListItemView extends LinearLayout {

    private TextView timeText;

    private TextView itemText;


    public ScheduleListItemView(Context context) {
        super(context);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_schedule_list_item, this, true);

        timeText = (TextView) findViewById(R.id.timeText);
        itemText = (TextView) findViewById(R.id.itemText);

    }

    public void setContents(int index, String data){

        if(index == 0) {
            timeText.setText(data);
        }
        else if(index==1){
            itemText.setText(data);
        }
        else{
            throw new IllegalArgumentException();
        }
    }


}



