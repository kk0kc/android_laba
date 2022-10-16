package com.example.androidlab

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.example.androidlab.databinding.FragmentListBinding
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter
import jp.wasabeef.recyclerview.adapters.SlideInRightAnimationAdapter
import jp.wasabeef.recyclerview.animators.OvershootInLeftAnimator


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
            val itemDecoration: RecyclerView.ItemDecoration =
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            adapter = SongAdapter(SongRepository.songs, Glide.with(this@ListFragment)) {
                song ->
                parentFragmentManager.beginTransaction()
//                .setCustomAnimations(
//                    android.R.anim.fade_in, android.R.anim.fade_out,
//                    android.R.anim.fade_in, android.R.anim.fade_out
//                )
                .replace(R.id.container, DetailFragment.newInstance(song.id))
                .addToBackStack("ListFragment")
                .commit()
            }




            rvSongs.adapter = ScaleInAnimationAdapter(adapter!!)
            rvSongs.addItemDecoration(itemDecoration)
            rvSongs.itemAnimator = OvershootInLeftAnimator()


//            rvSongs.adapter = SongAdapter(SongRepository.songs, Glide.with(this@ListFragment))
//            rvSongs.layoutManager = LinearLayoutManager(this@ListFragment)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}