package com.example.androidlab

import android.app.AlertDialog
import android.app.Service
import android.content.*
import android.os.Bundle
import android.os.IBinder
import android.view.View

import android.widget.TextView

import androidx.fragment.app.Fragment
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.androidlab.databinding.FragmentListBinding
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import jp.wasabeef.recyclerview.animators.OvershootInLeftAnimator


class ListFragment : Fragment(R.layout.fragment_list) {
    private var binding: FragmentListBinding? = null
    private var binder: PlayerService.TrackBinder? = null
    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            binder = service as? PlayerService.TrackBinder
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            binder = null
        }
    }

    private val receiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        LocalBroadcastManager.getInstance(context).registerReceiver(receiver, IntentFilter(UPDATE_UI))
    }

    override fun onDetach() {
        super.onDetach()
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(receiver)
    }

    override fun onStart() {
        super.onStart()
        requireActivity().bindService(
            Intent(requireActivity(), PlayerService::class.java),
            connection,
            Service.BIND_AUTO_CREATE
        )
        requireActivity().startService(Intent(requireActivity(), PlayerService::class.java))
    }
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
                .commit()

                if (song.isPlaying) {
                    binder?.playTrack(song.id)
                } else {
                    binder?.pauseTrack()
                }
                            },
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
    private fun onTrackClicked(trackId: Int) {
        val track = Repository.songs[trackId]
        val newItem = track.copy(isPlaying = !track.isPlaying)

//        Repository.songs.removeAt(trackId)
//        Repository.songs.add(trackId, newItem)
//
//        adapter?.submitList(Repository.tracksUi)

        if (newItem.isPlaying) {
            binder?.playTrack(newItem.id)
        } else {
            binder?.pauseTrack()
        }
    }
    companion object{
        var adapter: SongAdapter? = null
            const val PREVIOUS_TRACK_ID = "PREVIOUS_TRACK_ID"
            const val CURRENT_TRACK_ID = "CURRENT_TRACK_ID"
            const val UPDATE_UI = "UPDATE_UI"
            const val MEDIA_ACTION = "MEDIA_ACTION"
    }
}