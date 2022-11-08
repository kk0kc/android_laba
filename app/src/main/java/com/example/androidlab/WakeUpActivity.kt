package com.example.androidlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidlab.databinding.ActivityMainBinding
import com.example.androidlab.databinding.ActivityWakeUpBinding

class WakeUpActivity : AppCompatActivity() {
    private var binding: ActivityWakeUpBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWakeUpBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        setContentView(R.layout.activity_wake_up)
    }
}