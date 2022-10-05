package com.example.androidlab

import android.R
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidlab.databinding.ActivitySecondBinding
import java.text.SimpleDateFormat
import java.util.*


class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val sdf = SimpleDateFormat("HH:mm:ss")
        val time: String = sdf.format(Date(System.currentTimeMillis()))
        binding.tv.text = time
    }
}