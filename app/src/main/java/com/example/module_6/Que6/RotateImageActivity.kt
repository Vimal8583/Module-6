package com.example.module_6.Que6

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.module_6.R
import com.example.module_6.databinding.ActivityRotateImagrBinding

class RotateImageActivity : AppCompatActivity() {
    private var currentRotation = 0
    private lateinit var binding : ActivityRotateImagrBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRotateImagrBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val initialBitmap: Bitmap = loadInitialBitmap()
        binding.imageView.setImageBitmap(initialBitmap)

        binding.rotateButton.setOnClickListener {
            currentRotation = (currentRotation + 90) % 360
            val rotatedBitmap: Bitmap? = rotateBitmap(initialBitmap, currentRotation)
            rotatedBitmap?.let {
                binding.imageView.setImageBitmap(rotatedBitmap)
            }
        }
    }
    private fun loadInitialBitmap(): Bitmap {
        // Replace this with your image loading logic
        // For example, loading from resources:
        return BitmapFactory.decodeResource(resources, R.drawable.nature)
    }

    private fun rotateBitmap(source: Bitmap, degrees: Int): Bitmap? {
        val matrix = Matrix()
        matrix.postRotate(degrees.toFloat())
        return Bitmap.createBitmap(source, 0, 0, source.width, source.height, matrix, true)
    }
}