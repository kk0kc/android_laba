package com.example.androidlab

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.androidlab.databinding.ItemSongBinding
import androidx.recyclerview.widget.RecyclerView
import coil.load

class SongViewHolder(
    val binding: ItemSongBinding,
    val onItemClicked: ((MyItems.Song) -> Unit)?,
    val onDeleteClicked: ((Int) -> Unit)?,
) : RecyclerView.ViewHolder(binding.root) {

    init {
        with(binding) {
//          root.setOnClickListener {
//              onItemClicked?.invoke()
//          }
            buttonDelete.setOnClickListener{
                onDeleteClicked?.invoke(adapterPosition)
            }
        }
    }

    fun onBind(song: MyItems.Song) {
        with(binding) {
            name.text = song.name
            author.text = song.author
            cover.load(song.imageUrl)
            root.setOnClickListener{
                onItemClicked?.let { it1 -> it1(song) }
            }
        }
    }


    companion object {
        fun create(
            parent: ViewGroup,
            onItemClicked: ((MyItems.Song) -> Unit)?,
            onDeleteClicked: ((Int) -> Unit)?
        ): SongViewHolder = SongViewHolder(
            binding = ItemSongBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onItemClicked = onItemClicked,
            onDeleteClicked = onDeleteClicked,
        )
    }
}