package com.example.androidlab.secondlevel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidlab.R
import com.example.androidlab.databinding.FragmentFirstBinding
import com.example.androidlab.databinding.FragmentFourthBinding

class NewFourthFragment : Fragment(R.layout.fragment_new_fourth) {
    private var _binding: FragmentFourthBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFourthBinding.bind(view)
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
