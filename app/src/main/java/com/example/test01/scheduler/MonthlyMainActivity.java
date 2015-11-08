package com.example.test01.scheduler;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 김우정 on 2015-11-07.
 */
public class MonthlyMainActivity extends ActionBarActivity {

    CalendarMonthView monthView;

    CalendarMonthAdapter monthViewAdapter;

    TextView monthText;

    int curYear;

    int curMonth;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(com.example.test01.scheduler.R.layout.activity_monthly);

    monthView = (CalendarMonthView)findViewById(com.example.test01.scheduler.R.id.monthView);
    monthViewAdapter = new CalendarMonthAdapter(this);
    monthView.setAdapter(monthViewAdapter);

    monthView.setOnDataSelectionListener(new OnDataSelectionListener() {
        public void onDataSelected(AdapterView parent, View v, int position, long id) {
            // �쁽�옱 �꽑�깮�븳 �씪�옄 �젙蹂� �몴�떆
            MonthItem curItem = (MonthItem) monthViewAdapter.getItem(position);
            int day = curItem.getDay();

            Log.d("CalendarMonthViewActivity", "Selected : " + day);

        }
    });

    monthText = (TextView) findViewById(com.example.test01.scheduler.R.id.monthText);
    setMonthText();

    // �씠�쟾 �썡濡� �꽆�뼱媛��뒗 �씠踰ㅽ듃 泥섎━
    Button monthPrevious = (Button) findViewById(com.example.test01.scheduler.R.id.monthPrevious);
    monthPrevious.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            monthViewAdapter.setPreviousMonth();
            monthViewAdapter.notifyDataSetChanged();

            setMonthText();
        }
    });

    // �떎�쓬 �썡濡� �꽆�뼱媛��뒗 �씠踰ㅽ듃 泥섎━
    Button monthNext = (Button) findViewById(com.example.test01.scheduler.R.id.monthNext);
    monthNext.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            monthViewAdapter.setNextMonth();
            monthViewAdapter.notifyDataSetChanged();

            setMonthText();
        }
    });

}

    /**
     * �썡 �몴�떆 �뀓�뒪�듃 �꽕�젙
     */
    private void setMonthText() {
        curYear = monthViewAdapter.getCurYear();
        curMonth = monthViewAdapter.getCurMonth();

        monthText.setText(curYear + "�뀈 " + (curMonth+1) + "�썡");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.example.test01.scheduler.R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == com.example.test01.scheduler.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
