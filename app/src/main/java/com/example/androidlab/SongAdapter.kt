package com.example.androidlab

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.androidlab.databinding.ItemSongBinding

class SongAdapter(
    private val list: List<Song>,
    private val glide: RequestManager,
    private val onItemClick: (Song) -> Unit
) : RecyclerView.Adapter<SongItem>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SongItem = SongItem(
        binding = ItemSongBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
    ), glide = glide,
        onItemClick = onItemClick)


    override fun onBindViewHolder(
        holder: SongItem,
        position: Int
    ) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}