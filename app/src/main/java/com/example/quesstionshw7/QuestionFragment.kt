package com.example.quesstionshw7

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.quesstionshw7.databinding.FragmentQuestionBinding

var QNUMBER=0
class QuestionFragment: Fragment(R.layout.fragment_question) {
    val viewModelQuestion: QuestionViewModel by viewModels()
    lateinit var binding: FragmentQuestionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuestionBinding.inflate(layoutInflater, container , false)

        enabledButtons()
        showQuestion()
        answeredQuestion()
        errorCheat()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnNext.setOnClickListener { nextQuestion() }
        binding.btnPrev.setOnClickListener { prevQuestion() }
        binding.btnTrue.setOnClickListener { checkAnswer(true) }
        binding.btnFalse.setOnClickListener { checkAnswer(false) }
        binding.cheatBtn.setOnClickListener { cheat() }

    }
    private fun showQuestion() {
        binding.questionTxv.text = viewModelQuestion.questions[QNUMBER].question
    }
    private fun answeredQuestion() {
        if (viewModelQuestion.questions[QNUMBER].answered) {
            binding.btnFalse.isEnabled = false
            binding.btnTrue.isEnabled = false
            binding.cheatBtn.isEnabled = false
        } else {
            binding.btnFalse.isEnabled = true
            binding.btnTrue.isEnabled = true
            binding.cheatBtn.isEnabled = true
        }

    }
    private fun errorCheat() {
        if (viewModelQuestion.questions[QNUMBER].cheat) {
            binding.doCheatTxv.visibility = View.VISIBLE
        } else {
            binding.doCheatTxv.visibility = View.INVISIBLE
        }
    }
    private fun cheat() {
        findNavController().navigate(R.id.action_questionFragment3_to_answerFragment2)
    }
    private fun nextQuestion() {
        if (QNUMBER < 9) {
            QNUMBER +=1
            binding.btnPrev.isEnabled = true
        } else {
            binding.btnNext.isEnabled = false

        }
        showQuestion()
        answeredQuestion()
        errorCheat()
        enabledButtons()
    }
    private fun prevQuestion() {
        if (QNUMBER > 0) {
            QNUMBER--
            binding.btnNext.isEnabled = true
        } else {
            binding.btnPrev.isEnabled = false

        }
        showQuestion()
        answeredQuestion()
        errorCheat()
        enabledButtons()
    }
    private fun checkAnswer(answer: Boolean) {
        if (answer.toString() ==
            viewModelQuestion.questions[QNUMBER].answer) {
            Log.d("answersssss", viewModelQuestion.questions[QNUMBER].cheat.toString()+"2")
            if (viewModelQuestion.questions[QNUMBER].cheat) {
                Toast.makeText(activity, "cheat is wrong!", Toast.LENGTH_SHORT).show()
                binding.doCheatTxv.visibility = View.VISIBLE
            } else {
                Toast.makeText(activity, "correct", Toast.LENGTH_SHORT).show()
            }
        }
        else {
            Toast.makeText(activity, "incorrect!", Toast.LENGTH_SHORT).show()
        }
        viewModelQuestion.questions[QNUMBER].answered = true
        answeredQuestion()
    }
    private fun enabledButtons(){
        if (QNUMBER == 0){
            binding.btnPrev.isEnabled = false
        }
        else if (QNUMBER == 9){
            binding.btnNext.isEnabled = false
        }
    }
}