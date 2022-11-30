package com.example.androidlab

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
class SongAdapter(
    val differ: DiffUtil.ItemCallback<MyItems>,
    val onItemClicked: ((MyItems.Song)-> Unit)?,
    val onDeleteClicked: ((Int)-> Unit)
) :
    ListAdapter<MyItems, RecyclerView.ViewHolder>(differ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            R.layout.advertisement_layout -> AdvertisementViewHolder.create(parent)
            R.layout.item_song -> SongViewHolder.create(parent, onItemClicked, onDeleteClicked)
            else -> throw IllegalArgumentException("There is no viewHolder for such an item! : )")
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = currentList[position]
        when (holder) {
            is AdvertisementViewHolder -> holder.onBind(item as MyItems.Advertisement)
            is SongViewHolder -> holder.onBind(item as MyItems.Song)
        }
    }

    override fun getItemViewType(position: Int): Int =
        when(currentList[position]) {
            is MyItems.Song -> R.layout.item_song
            is MyItems.Advertisement -> R.layout.advertisement_layout
        }
}