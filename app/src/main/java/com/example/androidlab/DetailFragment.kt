package com.example.androidlab


import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.androidlab.databinding.FragmentDetailBinding


class DetailFragment : Fragment(R.layout.fragment_detail) {
    private var binding: FragmentDetailBinding? = null
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)
        val song : MyItems.Song = Repository.songs[arguments?.getInt("id")!!]
        with(binding) {
            this?.textDetail?.text = song.text
            this?.nameDetail?.text = "Song: " + song.name
            this?.authorDetail?.text = "Author: " + song.author
            Glide.with(this@DetailFragment)
                .load(song.imageUrl)
                .placeholder(R.drawable.def)
                .error(R.drawable.def)
                .into(this?.coverDetail!!)
            Glide.with(this@DetailFragment)
                .load(song.imageUrl)
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
