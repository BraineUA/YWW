package com.example.timteam.youwillwin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView button_Calendar;
    ImageView button_favorites;
    ImageView button_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_Calendar =findViewById(R.id.button_calendar);
        button_favorites=findViewById(R.id.button_favorites);
        button_menu=findViewById(R.id.button_menu);
    }



    public void clickFav(View view) {
    }

    public void clickCalendar(View view) {
        Intent intent_calendar = new Intent(this,CalendarActivity.class);
        startActivity(intent_calendar);


    }

    public void clickMenu(View view) {
    }
}
