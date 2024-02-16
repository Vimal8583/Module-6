package com.example.module_6.Que7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import com.example.module_6.R
import com.example.module_6.databinding.ActivityImageMoveBinding

class ImageMoveActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var binding : ActivityImageMoveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding= ActivityImageMoveBinding.inflate(layoutInflater)
        setContentView(binding.root)
       imageView= binding.imageView
        binding.moveButton.setOnClickListener {
            // Move the image to a new position
            moveImage()
        }

    }

    private fun moveImage() {
        val initialX = imageView.x
        val initialY = imageView.y

        val newX = initialX + 200 // Change this value for the new X position
        val newY = initialY + 200 // Change this value for the new Y position

        val translateAnimation = TranslateAnimation(0f, newX - initialX, 0f, newY - initialY)
        translateAnimation.duration = 1000 // Animation duration in milliseconds

        translateAnimation.setAnimationListener(object : android.view.animation.Animation.AnimationListener {
            override fun onAnimationStart(animation: android.view.animation.Animation) {}
            override fun onAnimationRepeat(animation: android.view.animation.Animation) {}

            override fun onAnimationEnd(animation: android.view.animation.Animation) {
                // Update the view's position after the animation completes
                imageView.x = newX
                imageView.y = newY
            }
        })

        imageView.startAnimation(translateAnimation)
    }
}