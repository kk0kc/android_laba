package com.example.androidlab

import android.app.AlertDialog
import android.os.Bundle
import android.view.View

import android.widget.TextView

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.androidlab.databinding.FragmentListBinding
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import jp.wasabeef.recyclerview.animators.OvershootInLeftAnimator


class ListFragment : Fragment(R.layout.fragment_list) {
    private var binding: FragmentListBinding? = null
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)
        initRecyclerView()
        initFloatingButton()
        binding?.run {
            val itemDecoration: RecyclerView.ItemDecoration =
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            rvSongs.adapter = ScaleInAnimationAdapter(adapter!!)
            rvSongs.addItemDecoration(itemDecoration)
            rvSongs.itemAnimator = OvershootInLeftAnimator()
        }
    }

    private fun initRecyclerView() {
        adapter = SongAdapter(
            differ = ListAdapterDiffUtil(),
            onItemClicked = {song->
                parentFragmentManager.beginTransaction()
                .replace(R.id.container, DetailFragment.newInstance(song.id))
                .addToBackStack("ListFragment")
                .commit()},
            onDeleteClicked = ::onDeleteClicked
        )
        Repository.generateList(10)
        adapter?.submitList(Repository.dataList)
        binding?.rvSongs?.adapter = adapter
        binding?.root?.let { SwipeToDelete(it, adapter).attachToRecyclerView(binding?.rvSongs) }
    }

    private fun initFloatingButton() {
        binding?.fab?.setOnClickListener {
            val dialog = DialogFragment()
            dialog.show(parentFragmentManager, "Custom dialog")
        }
    }


    private fun onDeleteClicked(position: Int) {
        Repository.deleteItem(requireContext(), position)
        adapter?.submitList(Repository.dataList)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
    companion object{
        var adapter: SongAdapter? = null
    }
}