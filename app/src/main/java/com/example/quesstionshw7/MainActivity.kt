package com.example.quesstionshw7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.quesstionshw7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    var quesstionNumber = 0
    var quesstionMap = mutableMapOf<String,String>()
    var quesstionArray = arrayListOf<String>()
    var answerArray = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        quesstionMap = mutableMapOf(getString(R.string.q1) to getString(R.string.a1) ,
            getString(R.string.q2) to getString(R.string.a2) ,
            getString(R.string.q3) to getString(R.string.a3) ,
            getString(R.string.q4) to getString(R.string.a4) ,
            getString(R.string.q5) to getString(R.string.a5) ,
            getString(R.string.q6) to getString(R.string.a6) ,
            getString(R.string.q7) to getString(R.string.a7) ,
            getString(R.string.q8) to getString(R.string.a8) ,
            getString(R.string.q9) to getString(R.string.a9) ,
            getString(R.string.q10) to getString(R.string.a10) )

        quesstionArray = arrayListOf(getString(R.string.q1),
            getString(R.string.q2) , getString(R.string.q3) ,
            getString(R.string.q4) , getString(R.string.q5) ,
            getString(R.string.q6) , getString(R.string.q7) ,
            getString(R.string.q8) , getString(R.string.q9) ,
            getString(R.string.q10))
        showQuesstion()
        binding.btnNext.setOnClickListener { nextQuesstion() }
        binding.btnPrev.setOnClickListener { preQuesstion() }
    }
    fun nextQuesstion(){
        if (quesstionNumber <9){
            quesstionNumber++
            binding.btnPrev.isClickable = true
        }else{
            binding.btnNext.isClickable = false
//            binding.btnNext.hintTextColors = getColor(R.color.gray)
        }
        showQuesstion()
    }
    fun preQuesstion(){
        if (quesstionNumber >0){
            quesstionNumber--
            binding.btnNext.isClickable = true
        }else{
            binding.btnPrev.isClickable = false
//            binding.btnPrev.background = getDrawable(R.color.gray)
        }
        showQuesstion()
    }
    fun showQuesstion(){
        binding.questionTxv.text = quesstionArray[quesstionNumber].toString()
    }
}