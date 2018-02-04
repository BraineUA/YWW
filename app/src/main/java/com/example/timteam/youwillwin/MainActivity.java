package com.example.timteam.youwillwin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.like.LikeButton;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends MyNotificationActivity {
    ImageView button_Calendar;
    ImageView button_favorites;
    ImageView button_menu;
    ImageView imageView;
    LikeButton likeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_Calendar = findViewById(R.id.button_calendar);
        button_favorites = findViewById(R.id.button_favorites);
        button_menu = findViewById(R.id.button_menu);
        imageView = findViewById(R.id.imageView);

        String month = new SimpleDateFormat("MMMM", Locale.ENGLISH).format(new Date());
        String day = new SimpleDateFormat("d", Locale.ENGLISH).format(new Date());
        String fileName = month.toLowerCase() + "_" + day;
        Context context = imageView.getContext();
        int id = context.getResources().getIdentifier(fileName, "drawable", context.getPackageName());
        imageView.setImageResource(id);


    }

    public void clickFav(View view) {
    }

    public void clickCalendar(View view) {
        Intent intent_calendar = new Intent(this, CalendarActivity.class);
        startActivity(intent_calendar);


    }

    public void clickMenu(View view) {
        showNotification(view);



    }
}