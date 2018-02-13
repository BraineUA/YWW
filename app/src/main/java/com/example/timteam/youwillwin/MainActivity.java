package com.example.timteam.youwillwin;

import android.content.ContentValues;
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
import com.like.OnLikeListener;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        likeBtn = findViewById(R.id.star_button);
        imageView = findViewById(R.id.imageView);
        String month = new SimpleDateFormat("MMMM", Locale.ENGLISH).format(new Date());
        String day = new SimpleDateFormat("d", Locale.ENGLISH).format(new Date());
        final String fileName = month.toLowerCase() + "_" + day;
        Context context = imageView.getContext();
        int id = context.getResources().getIdentifier(fileName, "drawable", context.getPackageName());
        imageView.setImageResource(id);

        likeBtn.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeBtn) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        R.string.Add_to_fav, Toast.LENGTH_SHORT);
                hui(fileName);
              toast.show();

            }

            @Override
            public void unLiked(LikeButton likeBtn) {
                
                Toast toast = Toast.makeText(getApplicationContext(),
                        R.string.Romove_fav, Toast.LENGTH_SHORT);
                toast.show();


            }
        });
        








    }

    public void clickFav(View view) {
        Intent intent_fav = new Intent(this, GalleryActivity.class);
        startActivity(intent_fav);

//        Toast.makeText(this, item, Toast.LENGTH_SHORT).show();

    }

    public void clickCalendar(View view) {
        Intent intent_calendar = new Intent(this, CalendarActivity.class);
        startActivity(intent_calendar);


    }

    public void clickMenu(View view) {
        showNotification(view);



    }

    public void hui(String name) {
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
        Cursor cursor = mDb.rawQuery("select * from images where name ='" + name + "'" , null);
        ContentValues contentValues = new ContentValues();
        contentValues.put("favorite", 1);
        mDb.update("images", contentValues, null, null);
        cursor.close();
        mDb.close();

    }





}
