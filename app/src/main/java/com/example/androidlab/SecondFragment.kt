package com.example.androidlab

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidlab.databinding.FragmentFirstBinding
import com.example.androidlab.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {
    private var binding: FragmentSecondBinding? = null
    var counter : Int? = null
    override fun onViewCreated(view: View,
                               savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSecondBinding.bind(view)
        counter = arguments?.getInt("counter")
        binding?.counter?.text = "Counter value:\n$counter"

        when (counter) {
            in 0..50 -> {
                view.setBackgroundColor(Color.argb(255, 153, 50, 204))
            }
            in 51..100 -> {
                view.setBackgroundColor(Color.argb(255, 205, 92, 92))
            }
            else -> {
                view.setBackgroundColor(Color.argb(255, 240, 230, 140))
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (counter != null) {
            outState.putInt("counter", counter!!)
        }
    }
    companion object {
        fun newInstance(counter : Int) : SecondFragment {
            val fragment = SecondFragment()
            val bundle = Bundle()
            bundle.putInt("counter", counter)
            fragment.arguments = bundle
            return fragment
        }
    }
}