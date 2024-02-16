package com.example.module_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.module_6.Adapter.QuestionListAdapter
import com.example.module_6.Model.Questions
import com.example.module_6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var questionList = mutableListOf<Questions>()
    private lateinit var questionAdapter: QuestionListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareData()
        questionAdapter = QuestionListAdapter(this,questionList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = questionAdapter
    }

    private fun prepareData() {
        questionList.add(
            Questions(
                1, "1. pic selected from gallery or camera after login to application.")
        )
        questionList.add(
            Questions(2,"2. Create an application to display Google map with current location also give options to change mode in map.")
        )
        questionList.add(
            Questions(3, "3. Create an application to input address and display marker on that address.")
        )
        questionList.add(
            Questions(4, "4. Create an application to suggest places as user type with help of Place autocomplete.")
        )
        questionList.add(
            Questions(5, "5. service provide by Google.")
        )
        questionList.add(
            Questions(6, "6. Write a code to rotate image.")
        )
        questionList.add(
            Questions(7,"7. Write a code to blink image.")
        )
        questionList.add(
            Questions(8, "8. Write a code to move image from one place to another place.")
        )
        questionList.add(
            Questions(9,"9.  Write a code to zoom in out image using animation.")
        )
        questionList.add(
            Questions(10, "10. Write a code to show progress frame by frame animation.")
        )
        questionList.add(
            Questions(11, "10. set animation on splash screen with app logo.")
        )
    }
}