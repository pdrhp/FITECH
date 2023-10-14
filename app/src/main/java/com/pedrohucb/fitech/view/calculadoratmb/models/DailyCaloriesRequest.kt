package com.pedrohucb.fitech.view.calculadoratmb.models

data class DailyCaloriesRequest(
    val status_code : String,
    val request_result : String,
    val data : DailyCaloriesData
)