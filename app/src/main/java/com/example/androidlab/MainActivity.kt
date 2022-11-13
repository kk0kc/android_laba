package com.example.androidlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.androidlab.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var controller: NavController
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(
                R.id.firstFragment,
                R.id.secondFragment,
                R.id.thirdFragment,
                R.id.fourthFragment,
                R.id.fifthFragment
            ),
            fallbackOnNavigateUpListener = ::onSupportNavigateUp
        )
        controller = (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment).navController
        findViewById<Toolbar>(androidx.appcompat.R.id.action_bar)
            .setupWithNavController(controller, appBarConfiguration)
        binding.bottomView.setupWithNavController(controller)
    }
}