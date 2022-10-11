package com.example.androidlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.example.androidlab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        if(savedInstanceState!=null){
            return
        }

        binding?.run {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, SecondFragment(),"SecondFragment")
                .add(R.id.container, ADialogFragment(),"DialogFragment")
                .add(R.id.container, FirstFragment(),"FirstFragment")
                .addToBackStack("FirstFragment")
                .commit()
        }
    }

}