package com.example.module_6.Que1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.module_6.R
import com.example.module_6.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
            binding.btnLogin.setOnClickListener {
                startActivity(Intent(this,LoginActivity::class.java))
            }
        binding.btnSignup.setOnClickListener {
            startActivity(Intent(this,HomeActivity::class.java))
        }
    }
}