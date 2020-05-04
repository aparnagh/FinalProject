package com.example.finalproject

import com.google.firebase.database.Exclude

data class SurveyResult (var numAnswers: Int = 0, var date: String = "", var time: Int = 0) {
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "numAnswers" to numAnswers,
            "date" to date,
            "time" to time
        )
    }
}

