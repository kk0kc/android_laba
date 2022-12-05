package com.example.androidlab


import android.annotation.SuppressLint
import android.app.Service
import android.content.*
import android.media.MediaParser
import android.media.MediaPlayer
import android.os.Bundle
import android.os.IBinder
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.bumptech.glide.Glide
import com.example.androidlab.databinding.FragmentDetailBinding


class DetailFragment : Fragment(R.layout.fragment_detail) {
    private var binding: FragmentDetailBinding? = null
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
            if (intent != null) {
                val currentTrackId: Int = intent.getIntExtra(ListFragment.CURRENT_TRACK_ID, 0)
                val mediaActions: String? = intent.getStringExtra(ListFragment.MEDIA_ACTION)

                if (mediaActions != null) {
                    if (mediaActions == "PLAY") {
                        initView(currentTrackId, PlayerService.ICON_PAUSE)
                    } else {
                        initView(currentTrackId, PlayerService.ICON_PLAY)
                    }
                }
            }
        }
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        LocalBroadcastManager.getInstance(context).registerReceiver(receiver, IntentFilter(ListFragment.UPDATE_UI))
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
    }
    @SuppressLint("SetTextI18n")
    private fun initView(id: Int, icon: Int) {
        val song: MyItems.Song = Repository.songs[id]

        binding?.run {
            Glide.with(this@DetailFragment)
                .load(song.imageUrl)
                .placeholder(R.drawable.def)
                .error(R.drawable.def)
                .into(this.coverDetail)
            Glide.with(this@DetailFragment)
                .load(song.imageUrl)
                .placeholder(R.drawable.def)
                .error(R.drawable.def)
                .into(this.coverDetail2)
            nameDetail.text ="Song: " + song.name
            authorDetail.text = "Author: " + song.author
            textDetail.text = song.text

            btnPlay.setImageResource(icon)


            if (icon == PlayerService.ICON_PLAY) {
                btnPlay.setOnClickListener {
                    binder?.playTrack(song.id)
                }
            } else {
                btnPlay.setOnClickListener {
                    binder?.pauseTrack()
                }
            }

            btnStop.setOnClickListener {
                binder?.stopTrack()
            }

            btnNext.setOnClickListener {
                binder?.nextTrack()
            }

            btnPrevious.setOnClickListener {
                binder?.previousTrack()
            }

            seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    if (fromUser) {
                        binder?.seek(progress)
                    }
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {

                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {

                }
            })
        }
    }
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)

//        val track: MyItems.Song = Repository.songs.single { it.id == arguments?.getInt(ARG_ID) }
        val song : MyItems.Song = Repository.songs[arguments?.getInt("id")!!]
        if (song.isPlaying) {
            initView(song.id, PlayerService.ICON_PAUSE)
        } else {
            initView(song.id, PlayerService.ICON_PLAY)
        }
        binding = FragmentDetailBinding.bind(view)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
    companion object {

        fun newInstance(id : Int) : DetailFragment {
            val fragment = DetailFragment()
            val bundle = Bundle()
            bundle.putInt("id", id)
            fragment.arguments = bundle
            return fragment
        }
            private const val ARG_ID = "ARG_ID"

            fun createBundle(id: Int) = DetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_ID, id)
                }
            }

    }
}
