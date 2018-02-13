package com.example.timteam.youwillwin;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;

/**
 * Created by TimTeam on 13.02.2018.
 */

public class ReminderService {


//    public class ReminderService extends IntentService {
//        private static final int NOTIF_ID = 1;
//
//        public ReminderService(){
//            super("ReminderService");
//        }
//
//        @Override
//        protected void onHandleIntent(Intent intent) {
//            NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//            long when = System.currentTimeMillis();         // notification time
//            Notification notification = new Notification(R.drawable.icon, "reminder", when);
//            notification.defaults |= Notification.DEFAULT_SOUND;
//            notification.flags |= notification.FLAG_AUTO_CANCEL;
//            Intent notificationIntent = new Intent(this, MyNotificationActivity.class);
//            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent , 0);
//            notification.setLatestEventInfo(getApplicationContext(), "It's about time", "You should open the app now", contentIntent);
//            nm.notify(NOTIF_ID, notification);
//        }
//
//    }
}
