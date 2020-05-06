package com.example.finalproject

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.HashMap


class MyViewModel(application: Application): AndroidViewModel(application) {


    var answers = MutableLiveData<SurveyResult>()
    val database = Firebase.database.reference
    var date = ""
    var highlightAns = BooleanArray(60)

    init {
        answers.value = SurveyResult()
    }


    fun addToDB()
         {
            // Create new post at /user-posts/$userid/$postid and at
            // /posts/$postid simultaneously
            val key = database.child("surveys").push().key
            answers.value!!.date = getDateNow()
             answers.value!!.time = getCurrentTime()
            val post = answers.value!!
//            val postValues = post.toMap()
//
//            val childUpdates = HashMap<String, Any>()
//           // childUpdates["/locations/$key"] = postValues
//            childUpdates["/$date/$key"] = postValues
//
//            database.updateChildren(childUpdates)
             database.child("$date").setValue(answers.value!!)
    }

    fun getNumAnswers(): Int{
        return answers.value!!.numAnswers
    }
    fun getDateNow(): String {
        date = LocalDate.now().toString()
        return LocalDate.now().toString()
    }
    private fun getCurrentTime(): Int {
        return LocalTime.now().toSecondOfDay()
    }
}