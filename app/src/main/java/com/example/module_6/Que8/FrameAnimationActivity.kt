package com.example.module_6.Que8

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.module_6.R
import com.example.module_6.databinding.ActivityFrameAnimationBinding

class FrameAnimationActivity : AppCompatActivity() {
    private lateinit var animationDrawable: AnimationDrawable
    private lateinit var binding : ActivityFrameAnimationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFrameAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.progressImageView
        binding.progressImageView.setBackgroundResource(R.drawable.animation)

        animationDrawable = binding.progressImageView.background as AnimationDrawable
        animationDrawable.start()
    }
}