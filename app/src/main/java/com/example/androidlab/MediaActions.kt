package com.example.androidlab

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
enum class MediaActions : Parcelable {
    PLAY, PAUSE, STOP, PREVIOUS, NEXT
}