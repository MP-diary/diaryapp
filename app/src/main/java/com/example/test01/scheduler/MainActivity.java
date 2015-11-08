package com.example.test01.scheduler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.test01.scheduler.R.layout.activity_main);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", java.util.Locale.getDefault());
        Date date = new Date();
        String today_date = getString(com.example.test01.scheduler.R.string.today_date);
        TextView today_date_view = (TextView)findViewById(com.example.test01.scheduler.R.id.today_date_view);
        String res_text = String.format(today_date, dateFormat.format(date));
        today_date_view.setText(res_text);

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

    public void dailyClick(View view){
        Intent intent = new Intent(this, DailyActivity.class);
        startActivity(intent);
    }
    public void monthlyClick(View view){
        Intent intent = new Intent(this, MonthlyMainActivity.class);
        startActivity(intent);
    }
}
