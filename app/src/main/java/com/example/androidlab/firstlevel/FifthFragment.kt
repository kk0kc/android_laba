package com.example.androidlab.firstlevel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidlab.R
import com.example.androidlab.databinding.FragmentFifthBinding
import com.example.androidlab.databinding.FragmentFirstBinding

class FifthFragment : Fragment(R.layout.fragment_fifth) {
    private var _binding: FragmentFifthBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFifthBinding.bind(view)
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}