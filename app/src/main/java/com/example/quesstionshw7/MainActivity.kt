package com.example.quesstionshw7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quesstionshw7.databinding.ActivityMainBinding
const val ANSWER = "answer"
class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    var quesstionNumber = 0
    var quesstionArray = arrayListOf<String>()
    var answerArray = arrayListOf<String>()
    var cheatArray = arrayListOf<Boolean>()
    var answered = arrayListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        answerArray = arrayListOf(getString(R.string.a1) ,
            getString(R.string.a2) , getString(R.string.a3) ,
            getString(R.string.a4) , getString(R.string.a5) ,
            getString(R.string.a6) , getString(R.string.a7) ,
            getString(R.string.a8) , getString(R.string.a9) ,
            getString(R.string.a10) )

        quesstionArray = arrayListOf(getString(R.string.q1),
            getString(R.string.q2) , getString(R.string.q3) ,
            getString(R.string.q4) , getString(R.string.q5) ,
            getString(R.string.q6) , getString(R.string.q7) ,
            getString(R.string.q8) , getString(R.string.q9) ,
            getString(R.string.q10))
        showQuesstion()

        answeredQuesstion()
        binding.btnNext.setOnClickListener { nextQuesstion() }
        binding.btnPrev.setOnClickListener { prevQuesstion() }
        binding.btnTrue.setOnClickListener { checkAnswer(true) }
        binding.btnFalse.setOnClickListener { checkAnswer(false) }
        binding.cheatBtn.setOnClickListener { cheat() }
    }

    private fun answeredQuesstion() {
        if (answered .contains( quesstionNumber)) {
            binding.btnFalse.isEnabled = false
            binding.btnTrue.isEnabled = false
            binding.cheatBtn.isEnabled = false
        } else {
            binding.btnFalse.isEnabled = true
            binding.btnTrue.isEnabled = true
            binding.cheatBtn.isEnabled = true
        }

    }

    private fun cheat() {
        val intent = Intent(this,AnswerActivity::class.java)
        intent.putExtra(ANSWER , answerArray[quesstionNumber].toString())
        startActivity(intent)
    }

    private fun checkAnswer(answer:Boolean) {
        if (answer.toString() == answerArray[quesstionNumber]){
            Toast.makeText(this,"correct" , Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"incorrect!" , Toast.LENGTH_SHORT).show()
        }
        answered.add(quesstionNumber)
        answeredQuesstion()
    }

    fun nextQuesstion(){
        if (quesstionNumber <9){
            quesstionNumber++
            binding.btnPrev.isEnabled = true
        }else{
            binding.btnNext.isEnabled = false

        }
        showQuesstion()
        answeredQuesstion()
    }
    fun prevQuesstion(){
        if (quesstionNumber >0){
            quesstionNumber--
            binding.btnNext.isEnabled = true
        }else{
            binding.btnPrev.isEnabled = false

        }
        showQuesstion()
        answeredQuesstion()
    }
    fun showQuesstion(){
        binding.questionTxv.text = quesstionArray[quesstionNumber].toString()
    }
}