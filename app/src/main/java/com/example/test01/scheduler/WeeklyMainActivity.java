package com.example.test01.scheduler;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

/**
 * Created by 김우정 on 2015-11-21.
 */
public class WeeklyMainActivity extends TabActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        TabHost tabHost = getTabHost();
        LayoutInflater.from(this).inflate(R.layout.activity_weekly, tabHost.getTabContentView(), true);

        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("일").setContent(R.id.view1));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("월").setContent(R.id.view2));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("화").setContent(R.id.view3));
        tabHost.addTab(tabHost.newTabSpec("tab4").setIndicator("수").setContent(R.id.view4));
        tabHost.addTab(tabHost.newTabSpec("tab5").setIndicator("목").setContent(R.id.view5));
        tabHost.addTab(tabHost.newTabSpec("tab6").setIndicator("금").setContent(R.id.view6));
        tabHost.addTab(tabHost.newTabSpec("tab7").setIndicator("토").setContent(R.id.view7));
    }
}
