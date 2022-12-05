package com.example.androidlab

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import androidx.annotation.DrawableRes
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class PlayerService : Service() {

    private var mediaPlayer = MediaPlayer()
    private var mediaPlayerCurrentPosition: Int = 0
    private var currentTrackId: Int = 0
    private var previousTrackId: Int = -1
//    private var notificationProvider: NotificationProvider? = null

    inner class TrackBinder : Binder() {

        fun playTrack(id: Int) {
            play(id)
        }

        fun pauseTrack() {
            pause()
        }

        fun stopTrack() {
            stop()
        }

        fun nextTrack() {
            next()
        }

        fun previousTrack() {
            previous()
        }

        fun seek(position: Int) {
            seekTo(position)
        }
    }

    override fun onCreate() {
        super.onCreate()
//        notificationProvider = NotificationProvider(baseContext)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.getParcelableExtra<MediaActions>("MEDIA_ACTION")?.let {
            when (it) {
                MediaActions.PLAY -> play(currentTrackId)
                MediaActions.PAUSE -> pause()
                MediaActions.STOP -> stop()
                MediaActions.PREVIOUS -> previous()
                MediaActions.NEXT -> next()
            }
        }

        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder = TrackBinder()

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }

    private fun play(id: Int) {
        if (mediaPlayer.isPlaying) {
            mediaPlayerCurrentPosition = 0
            mediaPlayer.stop()
        }

        if (currentTrackId != id) {
            mediaPlayerCurrentPosition = 0
            mediaPlayer.stop()
        }

        currentTrackId = id

        mediaPlayer = MediaPlayer.create(applicationContext, Repository.getTrack(id).raw!!)
//        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.instasamka)
        mediaPlayer.start()
        mediaPlayer.seekTo(mediaPlayerCurrentPosition)
        mediaPlayer.setOnCompletionListener {
            next()
        }

//        updateNotification(ICON_PAUSE, id, MediaActions.PLAY, mediaPlayer.duration, mediaPlayerCurrentPosition)
        updateUi(currentTrackId, "PLAY")
    }

    private fun pause() {
        mediaPlayerCurrentPosition = mediaPlayer.currentPosition
        mediaPlayer.stop()
//        updateNotification(ICON_PLAY, currentTrackId, MediaActions.PAUSE, mediaPlayer.duration, mediaPlayerCurrentPosition)
        updateUi(currentTrackId, "PAUSE")
    }

    private fun stop() {
        mediaPlayer.stop()
        mediaPlayerCurrentPosition = 0
//        updateNotification(ICON_PLAY, currentTrackId, MediaActions.STOP, mediaPlayer.duration, mediaPlayerCurrentPosition)
        updateUi(currentTrackId, "PAUSE")
    }

    private fun next() {
        mediaPlayerCurrentPosition = 0

        previousTrackId = currentTrackId

        if (currentTrackId == -1) {
            return
        }

        currentTrackId = if (currentTrackId < Repository.songs.size - 1) {
            currentTrackId + 1
        } else {
            0
        }

        updateUi(previousTrackId, currentTrackId)
        play(currentTrackId)
    }

    private fun previous() {
        previousTrackId = currentTrackId

        if (currentTrackId == -1) {
            return
        }

        currentTrackId = if (currentTrackId > 0) {
            currentTrackId - 1
        } else {
            Repository.songs.size - 1
        }

        updateUi(previousTrackId, currentTrackId)
        play(currentTrackId)
    }

    private fun seekTo(position: Int) {
        mediaPlayer.seekTo(position)
    }

    private fun updateUi(previousId: Int, currentId: Int) {
        val intent = Intent(ListFragment.UPDATE_UI)
        intent.putExtra(ListFragment.PREVIOUS_TRACK_ID,previousId)
        intent.putExtra(ListFragment.CURRENT_TRACK_ID, currentId)
        LocalBroadcastManager.getInstance(this@PlayerService).sendBroadcast(intent)
    }

    private fun updateUi(currentId: Int, action: String) {
        val intent = Intent(ListFragment.UPDATE_UI)
        intent.putExtra(ListFragment.CURRENT_TRACK_ID, currentId)
        intent.putExtra(ListFragment.MEDIA_ACTION, action)
        LocalBroadcastManager.getInstance(this@PlayerService).sendBroadcast(intent)
    }

//    private fun updateNotification(@DrawableRes icon: Int, currentTrackId: Int, action: MediaActions, duration: Int, current: Int) {
//        val notification = notificationProvider?.createNotification(icon, currentTrackId, action, duration, current)
//        startForeground(NotificationProvider.NOTIFICATION_ID, notification)
//    }

    companion object {
        const val ICON_PAUSE = R.drawable.ic_pause
        const val ICON_PLAY = R.drawable.ic_play

        val PENDING_INTENT_FLAG =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                PendingIntent.FLAG_MUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
            } else {
                PendingIntent.FLAG_UPDATE_CURRENT
            }
    }
}