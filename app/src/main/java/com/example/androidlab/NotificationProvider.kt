package com.example.androidlab

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.AudioAttributes
import android.net.Uri
import android.os.Build
import android.os.CombinedVibration
import androidx.core.app.NotificationCompat
import okhttp3.internal.notify
import java.util.*

class NotificationProvider(private val context: Context) {
    val notificationManager: NotificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    val vibrations = arrayOf(100L, 200L).toLongArray()
    val audioAttributes: AudioAttributes = AudioAttributes.Builder()
        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
        .setUsage(AudioAttributes.USAGE_NOTIFICATION)
        .build()
    val sound: Uri = Uri.parse(
        "android.resource://" + context.packageName + "/" + R.raw.krik_petuxa
    )
    fun showNotification() {
        val intent = Intent(context, WakeUpActivity::class.java)
        val pending = PendingIntent.getActivity(
            context,
            100,
            intent,
            PendingIntent.FLAG_ONE_SHOT,
        )
        val builder: NotificationCompat.Builder =
            NotificationCompat.Builder(
                context,
                "11"
            )
                .setSmallIcon(R.drawable.ic_alarm)
                .setContentTitle("Будильник")
                .setContentText("Подъеeм!")
                .setAutoCancel(true)
                .setSound(sound)
                .setVibrate(vibrations)
                .setContentIntent(pending)
                .setCategory(NotificationCompat.CATEGORY_ALARM)
                .setVisibility(NotificationCompat.VISIBILITY_PRIVATE)
                .setLights(Color.BLUE, 100, 500)
        notificationManager.notify(2132, builder.build())
    }
    fun createChannel() {
        val audioAttributes: AudioAttributes = AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .setUsage(AudioAttributes.USAGE_NOTIFICATION)
            .build()
        val sound: Uri = Uri.parse(
            "android.resource://" + context.packageName + "/" + R.raw.krik_petuxa
        )
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