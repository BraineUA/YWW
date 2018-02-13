package com.example.timteam.youwillwin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class CalendarActivity extends Activity {
    ImageView imageView;
    CalendarView calendarView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        imageView= (ImageView)findViewById(R.id.imageViewcal);
        calendarView=(CalendarView)findViewById(R.id.Calendar);
        String month = new SimpleDateFormat("MMMM", Locale.ENGLISH).format(new Date());
        String day = new SimpleDateFormat("d", Locale.ENGLISH).format(new Date());
        String fileName = month.toLowerCase() + "_" + day;
        Context context = imageView.getContext();
        int id = context.getResources().getIdentifier(fileName, "drawable", context.getPackageName());
        imageView.setImageResource(id);





    }
}


