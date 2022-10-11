package com.example.androidlab

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.androidlab.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {
    var counter = 0
    private var binding: FragmentFirstBinding? = null
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFirstBinding.bind(view)

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("counter")
        }
        binding?.buttonDialog?.setOnClickListener {
            ADialogFragment.newInstance(counter).show(parentFragmentManager, "Dialog")
        }
        if (arguments?.getInt("change") != null){
            counter = arguments?.getInt("change")!!
        }
        binding?.counter?.text = "Counter value:\n$counter"
        binding?.buttonToSecond?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .setCustomAnimations(
                    android.R.anim.fade_in, android.R.anim.fade_out,
                    android.R.anim.fade_in, android.R.anim.fade_out
                )
                .add(R.id.container, SecondFragment.newInstance(counter))
                .addToBackStack("FirstFragment")
                .commit()
        }
        binding?.buttonCounter?.setOnClickListener {
            counter++
            binding?.counter?.text = "Counter value:\n$counter"
        }
        binding?.counter?.text = "Counter value:\n$counter"



    }



    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counter", counter)
    }

    companion object {

        fun newInstance(change : Int) : FirstFragment {
            val fragment = FirstFragment()
            val bundle = Bundle()
            bundle.putInt("change", change)
            fragment.arguments = bundle
            return fragment
        }

    }
}