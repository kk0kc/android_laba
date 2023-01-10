package com.example.androidlab

sealed class MyItems(val id_model: Int) {
    data class Advertisement(val title: String, val imageUrl:String): MyItems(0)
    data class Song(val id: Int, var name: String, var author: String, val imageUrl:String, var text:String): MyItems(0)
}
