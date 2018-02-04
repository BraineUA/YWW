package com.example.timteam.youwillwin;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by TimTeam on 04.02.2018.
 */


public class MyNotificationActivity extends Activity {
    public NotificationManager nm;
    public final int NOTIFICATION_ID = 127;
    public View view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nm =(NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public void showNotification(View view){
        this.view = view;
        Notification.Builder builder = new Notification.Builder(getApplicationContext());
        Intent finish = new Intent(getApplicationContext(),MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0,finish, PendingIntent.FLAG_CANCEL_CURRENT);
        builder
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setLargeIcon(BitmapFactory.decodeResource(getApplication().getResources(),R.drawable.ic_launcher_foreground))
                .setTicker("Новое уведомление")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentTitle("Уведомление")
                .setContentText("Нажмите чтобы узнать ");
        Notification notification = builder.build();
        notification.defaults = Notification.DEFAULT_ALL;
        nm.notify(NOTIFICATION_ID,notification);




    }

}
