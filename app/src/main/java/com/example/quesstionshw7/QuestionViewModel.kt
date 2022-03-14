package com.example.quesstionshw7

import androidx.lifecycle.ViewModel

class QuestionViewModel: ViewModel() {
    var questionNumber = 0
    val answerArray = arrayListOf(
    "false",
    "true", "true",
    "true", "false",
    "false", "true",
    "false", "true",
    "true"
    )

    val questionArray = arrayListOf(
    "1_برای تجزیه ی نور خورشید از آینه استفاده می شود.",
        "2_خورشید چشمه ی اصلی نور طبیعی و گرمای زمین است.",
        "3_نور یکی از شکل های انرژی است.",
    "4_ذره بین را از شیشه و به شکل عدس می سازند.",
        "5_در فرغون تکیه گاه در وسط قرار دارد.",
        "6_پنکه یک ماشین ساده است.",
        "7_آهنی که زنگ می زند ، می پوسد و مقاومتش کم می شود.",
        "8_محل قرار گرفتن تکیه گاه در همه ی اهرم ها یکسان است.",
        "9_نام علمی زنگ آهن اکسید آهن است.",
        "10_در تغییر شیمیایی جنس ماده عوض نمی شود."
    )

    var questions = arrayListOf<QuestionClass>(

        QuestionClass(questionArray[0],answerArray[0],false,false),
        QuestionClass(questionArray[1],answerArray[1],false,false),
        QuestionClass(questionArray[2],answerArray[2],false,false),
        QuestionClass(questionArray[3],answerArray[3],false,false),
        QuestionClass(questionArray[4],answerArray[4],false,false),
        QuestionClass(questionArray[5],answerArray[5],false,false),
        QuestionClass(questionArray[6],answerArray[6],false,false),
        QuestionClass(questionArray[7],answerArray[7],false,false),
        QuestionClass(questionArray[8],answerArray[8],false,false),
        QuestionClass(questionArray[9],answerArray[9],false,false)
    )
}