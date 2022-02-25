package com.example.quesstionshw7

data class QuestionClass (val question:String , val answer:String ,
                          var answered:Boolean , var cheat:Boolean){

    var questions = arrayListOf<QuestionClass>(

    )
}