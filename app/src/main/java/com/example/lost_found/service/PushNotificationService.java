package com.example.lost_found.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.example.lost_found.FounditemActivity;
import com.example.lost_found.MainActivity;
import com.example.lost_found.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class PushNotificationService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        showNotification();
    }

    private void showNotification() {
        //membuat notification manager
        NotificationManager notificationManager = (NotificationManager)  getSystemService(NOTIFICATION_SERVICE);

        //buat notification channel
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel notificationChannel = new NotificationChannel(
                    "com.example.lost_found.CH01",
                    "Channel FBCM Lostnfound",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            notificationManager.createNotificationChannel(notificationChannel);
        }

        //Buat Pending Intent ke FoundItem
        Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);

        PendingIntent pendingMainIntent = PendingIntent.getActivity(
                getApplicationContext(),
                12345,
                mainIntent,
                PendingIntent.FLAG_UPDATE_CURRENT

        );

        //Buat Notifikasi
        Notification notification = new NotificationCompat.Builder(getApplicationContext(), "com.example.lost_found.CH01")
                .setSmallIcon(R.drawable.bag)
                .setContentTitle("BARANG TEMUAN ALERTT!!👌👌👌")
                .setContentText("barang hilang baru saja ditambahkan")
                .addAction(R.drawable.bag, "LIHAT", pendingMainIntent)
                .build();

        //tampilkan notifikasi
        notificationManager.notify(123, notification);

    }
}