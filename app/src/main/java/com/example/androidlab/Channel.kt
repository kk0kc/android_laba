package com.example.androidlab

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.media.AudioAttributes
import android.os.Build
import androidx.core.app.NotificationCompat
import java.net.URI

class Channel(private val context: Context, val vibrations: LongArray,
              val notificationManager: NotificationManager,
              ) {
    fun createChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel(
                "11",
                "22",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                lightColor = Color.BLUE
                vibrationPattern = vibrations
                setSound(sound, audioAttributes)
            }.also {
                notificationManager.createNotificationChannel(it)
            }
        }

    }
}