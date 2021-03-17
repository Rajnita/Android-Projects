package com.example.student.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {


    CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //sets the main layout of the activity
        setContentView(R.layout.activity_main);

        //initializes the calendarview
        initializeCalendar();
    }

    public void initializeCalendar() {
        calendar = (CalendarView) findViewById(R.id.calendar);


        calendar.setShowWeekNumber(false);


        calendar.setFirstDayOfWeek(1);

        calendar.setSelectedWeekBackgroundColor(getResources().getColor(R.color.green));


        calendar.setUnfocusedMonthDateColor(getResources().getColor(R.color.transparent));

        calendar.setWeekSeparatorLineColor(getResources().getColor(R.color.transparent));


        calendar.setSelectedDateVerticalBar(R.color.darkgreen);
        calendar.setOnDateChangeListener(new OnDateChangeListener() {

            //show the selected date as a toast
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                Toast.makeText(getApplicationContext(), day + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
            }
        });
    }
}


