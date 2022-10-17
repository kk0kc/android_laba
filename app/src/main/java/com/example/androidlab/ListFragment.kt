package com.example.androidlab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.androidlab.databinding.FragmentListBinding

class ListFragment : Fragment(R.layout.fragment_list) {
    private var adapter: SongAdapter? = null
    private var binding: FragmentListBinding? = null
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)
        binding?.run {
            rvSongs.adapter = SongAdapter(SongRepository.songs, Glide.with(this@ListFragment))
//            rvSongs.layoutManager = LinearLayoutManager(this@ListFragment)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}