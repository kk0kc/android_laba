package com.example.androidlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.androidlab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.edit.setOnClickListener{
            if(binding.avatar.isVisible) {
                binding.avatar.visibility = View.GONE
            } else { binding.avatar.visibility = View.VISIBLE}
        }
    }
}