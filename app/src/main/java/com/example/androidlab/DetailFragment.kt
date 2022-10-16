package com.example.androidlab


import android.app.Activity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.androidlab.databinding.FragmentDetailBinding


class DetailFragment : Fragment(R.layout.fragment_detail) {
    private var binding: FragmentDetailBinding? = null
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)
        val song : Song = SongRepository.songs[arguments?.getInt("id")!!]

        with(binding) {
            this?.textDetail?.text = song.text
            this?.nameDetail?.text = song.name
            this?.authorDetail?.text = song.author
            Glide.with(this@DetailFragment)
                .load(song.cover)
                .placeholder(R.drawable.def)
                .error(R.drawable.def)
                .into(this?.coverDetail!!)
            Glide.with(this@DetailFragment)
                .load(song.cover)
                .placeholder(R.drawable.def)
                .error(R.drawable.def)
                .into(this.coverDetail2)
            this.textDetail.movementMethod = ScrollingMovementMethod()
        }


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

    }
}
