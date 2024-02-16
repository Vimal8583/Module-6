package com.example.module_6.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.module_6.Model.Questions
import com.example.module_6.Que1.LoginActivity
import com.example.module_6.Que2.AutoCompleteMapActivity
import com.example.module_6.Que2.MapsActivity
import com.example.module_6.Que3.DisplayMarkerActivity
import com.example.module_6.Que6.BlinkActivity
import com.example.module_6.Que6.RotateImageActivity
import com.example.module_6.Que7.ImageMoveActivity
import com.example.module_6.Que7.ZoomInOutActivity
import com.example.module_6.Que8.FrameAnimationActivity
import com.example.module_6.Que9.SplashActivity
import com.example.module_6.databinding.QuestionListBinding

class QuestionListAdapter(var context: Context , var quesList: MutableList<Questions>):
    RecyclerView.Adapter<QuestionListAdapter.MyViewHolder>(){
    class MyViewHolder(val binding: QuestionListBinding):RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType:Int
    ):QuestionListAdapter.MyViewHolder {
        var binding = QuestionListBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return quesList.size
    }

    override fun onBindViewHolder(holder: QuestionListAdapter.MyViewHolder, position: Int) {
        var Quest = quesList[position]
        holder.binding.tvQuest.text = "${Quest.ques}"
        holder.binding.cardView.setOnClickListener {
            when(Quest.id) {
                1 -> {
                    val intent = Intent(context, LoginActivity::class.java)
                    context.startActivity(intent)
                }
                2 ->{
                    val intent  = Intent(context,MapsActivity::class.java)
                    context.startActivity(intent)
                }
                3 ->{
                    val intent  = Intent(context,DisplayMarkerActivity::class.java)
                    context.startActivity(intent)
                }
                4->{
                    val intent = Intent(context, AutoCompleteMapActivity::class.java)
                    context.startActivity(intent)
                }

                6 -> {
                    val intent = Intent(context, BlinkActivity::class.java)
                    context.startActivity(intent)
                }


                7 -> {
                    val intent = Intent(context, RotateImageActivity::class.java)
                    context.startActivity(intent)
                }

                8 -> {
                    val intent = Intent(context, ImageMoveActivity::class.java)
                    context.startActivity(intent)
                }

                9 -> {
                    val intent = Intent(context,ZoomInOutActivity::class.java)
                    context.startActivity(intent)
                }

                10 -> {
                    val intent = Intent(context, FrameAnimationActivity::class.java)
                    context.startActivity(intent)
                }

                11 -> {
                    val intent = Intent(context, SplashActivity::class.java)
                    context.startActivity(intent)
                }
            }
        }
    }

}