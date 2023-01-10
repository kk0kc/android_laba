package com.example.androidlab

import androidx.recyclerview.widget.DiffUtil

class ListAdapterDiffUtil : DiffUtil.ItemCallback<MyItems>() {
    override fun areItemsTheSame(oldItem: MyItems, newItem: MyItems): Boolean =
        oldItem.id_model == newItem.id_model

    override fun areContentsTheSame(oldItem: MyItems, newItem: MyItems): Boolean =
        oldItem == newItem

}