package com.example.timteam.youwillwin;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.like.LikeButton;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends MyNotificationActivity {
    ImageView button_Calendar;
    ImageView button_favorites;
    ImageView button_menu;
    ImageView imageView;
    LikeButton likeBtn;

    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_Calendar = findViewById(R.id.button_calendar);
        button_favorites = findViewById(R.id.button_favorites);
        button_menu = findViewById(R.id.button_menu);
        imageView = findViewById(R.id.imageView);

        mDBHelper = new DatabaseHelper(this);

        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }


        String month = new SimpleDateFormat("MMMM", Locale.ENGLISH).format(new Date());
        String day = new SimpleDateFormat("d", Locale.ENGLISH).format(new Date());
        String fileName = month.toLowerCase() + "_" + day;
        Context context = imageView.getContext();
        int id = context.getResources().getIdentifier(fileName, "drawable", context.getPackageName());
        imageView.setImageResource(id);


    }

    public void clickFav(View view) {

//        String item = "";
//
//        Cursor cursor = mDb.rawQuery("SELECT * FROM images WHERE favorite = 1", null);
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            item += cursor.getString(1) + "  " + cursor.getString(2);
//            cursor.moveToNext();
//        }
//        cursor.close();
//
//        Toast.makeText(this, item, Toast.LENGTH_SHORT).show();

    }

    public void clickCalendar(View view) {
        Intent intent_calendar = new Intent(this, CalendarActivity.class);
        startActivity(intent_calendar);


    }

    public void clickMenu(View view) {
        showNotification(view);



    }



}