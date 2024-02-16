package com.example.module_6.Que7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import com.example.module_6.R
import com.example.module_6.databinding.ActivityZoomInOutBinding

class ZoomInOutActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var binding : ActivityZoomInOutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityZoomInOutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        imageView = binding.imageView
        binding.zoomInButton.setOnClickListener {
            // Zoom in the image
            zoomImage(1.5f)
        }

        binding.zoomOutButton.setOnClickListener {
            // Zoom out the image
            zoomImage(0.5f)
        }
    }

    private fun zoomImage(scaleFactor: Float) {
        val scaleAnimation = ScaleAnimation(
            1f, scaleFactor,
            1f, scaleFactor,
            ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
            ScaleAnimation.RELATIVE_TO_SELF, 0.5f
        )

        scaleAnimation.duration = 500 // Animation duration in milliseconds
        scaleAnimation.fillAfter = true

        imageView.startAnimation(scaleAnimation)

    }
}