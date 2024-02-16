package com.example.module_6.Que6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import com.example.module_6.databinding.ActivityBlinkBinding

class BlinkActivity : AppCompatActivity() {
    private lateinit var imageView : ImageView
    private var isBlinking = false
    private val handler = Handler()
    private lateinit var blinkRunnable: Runnable
    private lateinit var binding : ActivityBlinkBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlinkBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var imageView = binding.imageView

        blinkRunnable = object : Runnable {
            override fun run() {
                if (isBlinking) {
                    imageView.visibility = if (imageView.visibility == View.VISIBLE) View.INVISIBLE else View.VISIBLE
                    handler.postDelayed(this, BLINK_INTERVAL.toLong())
                } else {
                    imageView.visibility = View.VISIBLE
                }
            }
        }

        // Start blinking when the activity starts (you can trigger it based on your requirements)
        startBlinking()
    }

    private fun startBlinking() {
        isBlinking = true
        handler.post(blinkRunnable)
    }

    private fun stopBlinking() {
        isBlinking = false
        handler.removeCallbacks(blinkRunnable)
        imageView.visibility = View.VISIBLE
    }
}
private const val BLINK_INTERVAL = 600 // Blink interval in milliseconds