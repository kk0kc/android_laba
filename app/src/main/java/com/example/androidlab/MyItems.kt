package com.example.androidlab

import androidx.annotation.RawRes

sealed class MyItems(val id_model: Int) {
    data class Advertisement(val title: String, val imageUrl:String): MyItems(0)
    data class Song(val id: Int, var name: String, var author: String, val imageUrl:String, var text:String, @RawRes val raw: Int?, val isPlaying: Boolean = false): MyItems(0)
}
