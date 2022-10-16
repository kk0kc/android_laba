package com.example.androidlab


import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.androidlab.databinding.ItemSongBinding

class SongItem(
    private val binding: ItemSongBinding,
    private val glide: RequestManager,
    private val onItemClick: (Song) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    var option = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL)
        .priority(Priority.HIGH)
    fun onBind(song: Song) {
        with(binding) {
            name.text = song.name
            author.text = song.author
            root.setOnClickListener{
                onItemClick(song)
            }
            glide
                .load(song.cover)
                .apply(option)
                .placeholder(R.drawable.def)
                .error(R.drawable.def)
                .into(cover)



        }
    }
}