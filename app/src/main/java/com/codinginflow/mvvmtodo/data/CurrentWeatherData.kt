package com.codinginflow.mvvmtodo.data

data class CurrentWeatherData(
    val temp_c: Float,
    val is_day: Int,
    val condition: ConditionWeatherData,
    val wind_kph: Float,
    val wind_dir: String
) {
}