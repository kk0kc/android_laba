package com.example.androidlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidlab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        binding?.run {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, ListFragment(),"ListFragment")
                .commit()
        }
    }
}