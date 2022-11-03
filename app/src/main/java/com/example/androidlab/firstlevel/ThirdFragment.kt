package com.example.androidlab.firstlevel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidlab.R
import com.example.androidlab.databinding.FragmentFirstBinding
import com.example.androidlab.databinding.FragmentThirdBinding

class ThirdFragment : Fragment(R.layout.fragment_third) {
    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentThirdBinding.bind(view)

        binding.firstBut.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_newFirstFragment)
        }
        binding.secondBut.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_newSecondFragment)
        }
        binding.thirdBut.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_newThirdFragment)
        }
        binding.fourthBut.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_newFourthFragment)
        }
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}