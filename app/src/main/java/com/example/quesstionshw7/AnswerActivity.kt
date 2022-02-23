package com.example.quesstionshw7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quesstionshw7.databinding.ActivityAnswerBinding

class AnswerActivity : AppCompatActivity() {
    lateinit var binding :ActivityAnswerBinding
    lateinit var answer :String
    var cheat =false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnswerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        answer = intent.getStringExtra(ANSWER).toString()
        binding.btnShowAnswer.setOnClickListener { showAnswer(answer) }

    }

    private fun showAnswer(ans:String) {
        cheat = true
        binding.texvShowAnswer.text = ans
    }
}