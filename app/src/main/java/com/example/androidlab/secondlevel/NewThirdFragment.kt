package com.example.androidlab.secondlevel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidlab.R
import com.example.androidlab.databinding.FragmentFirstBinding
import com.example.androidlab.databinding.FragmentNewThirdBinding
import com.example.androidlab.databinding.FragmentThirdBinding

class NewThirdFragment : Fragment(R.layout.fragment_new_third) {
    private var _binding: FragmentNewThirdBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNewThirdBinding.bind(view)
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
