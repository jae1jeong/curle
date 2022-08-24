package com.james.curly.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.james.curly.domain.repository.AppDataRepository
import com.james.curly.presentation.MainActivity
import com.james.curly.utils.Constants
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity:AppCompatActivity() {
    @Inject lateinit var appDataRepository: AppDataRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val handler  = Handler()

        val r = Runnable {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        handler.postDelayed(r,2500)
    }
}