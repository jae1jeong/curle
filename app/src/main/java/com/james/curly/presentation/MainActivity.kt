package com.james.curly.presentation

import android.os.Build
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.navigation.NavHost
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.james.curly.R
import com.james.curly.databinding.ActivityMainBinding
import com.james.curly.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: ActivityViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.myBottomNav, navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->


            when (destination.id) {
                R.id.homeFragment -> {
                    binding.myBottomNav.visibility = View.VISIBLE
                    binding.navHost.root.setPadding(0, 0, 0, 0)

                }

                R.id.categoryFragment -> {
                    binding.myBottomNav.visibility = View.VISIBLE
                    binding.navHost.root.setPadding(0, 0, 0, 0)
                }

                R.id.searchFragment -> {
                    binding.myBottomNav.visibility = View.VISIBLE
                    binding.navHost.root.setPadding(0, 0, 0, 0)

                }
                R.id.myPageFragment -> {
                    binding.myBottomNav.visibility = View.VISIBLE
                    binding.navHost.root.setPadding(0, 0, 0, 0)

                }
                else -> {
                    binding.myBottomNav.visibility = View.GONE
                    binding.navHost.root.setPadding(0, 0, 0, 0)
                }
            }

            // status bar color by fragment
            when (destination.id) {
                R.id.homeFragment -> {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        window.statusBarColor = ContextCompat.getColor(this, R.color.main_color);
                    }
                }

                R.id.searchFragment ->{
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        window.statusBarColor = ContextCompat.getColor(this, R.color.main_color);
                    }
                }

                else -> {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                        window.statusBarColor = ContextCompat.getColor(this, R.color.white);
                    }
                }
            }
        }
    }


}