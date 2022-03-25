package com.example.quesstionshw7

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.quesstionshw7.databinding.FragmentAnswerBinding

class AnswerFragment:Fragment(R.layout.fragment_answer) {
//    val viewModelAnswer=QuestionFragment().viewModelQuestion
    val viewModelAnswer : QuestionViewModel by activityViewModels()
    lateinit var binding: FragmentAnswerBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnswerBinding.inflate(layoutInflater, container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnShowAnswer.setOnClickListener{
            viewModelAnswer.cheated(QNUMBER)
//            viewModelAnswer.questions[QNUMBER].cheat=true
            binding.texvShowAnswer.text =
                viewModelAnswer.getAnswer(QNUMBER)
        }
    }
}