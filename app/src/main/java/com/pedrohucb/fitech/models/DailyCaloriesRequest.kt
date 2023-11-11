package com.pedrohucb.fitech.models

data class DailyCaloriesRequest(
    val status_code : String,
    val request_result : String,
    val data : DailyCaloriesData
)