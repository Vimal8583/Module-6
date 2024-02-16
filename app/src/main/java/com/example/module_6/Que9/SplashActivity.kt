package com.example.module_6.Que9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import com.example.module_6.Que1.HomeActivity
import com.example.module_6.R
import com.example.module_6.databinding.ActivitySplashBinding
import com.google.android.material.animation.AnimationUtils
import kotlin.concurrent.thread

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var logoImage = binding.logoImageView
        var fadeIn = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.fade_in)
        binding.logoImageView.startAnimation(fadeIn)
        Thread(
            Runnable {
                Thread.sleep(5000)

                        var intent = Intent(this,HomeActivity::class.java)
                        startActivity(intent)
                        finish()

            }
        ).start()
    }
}