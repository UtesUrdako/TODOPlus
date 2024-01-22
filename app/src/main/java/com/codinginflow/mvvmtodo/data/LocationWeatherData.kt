package com.codinginflow.mvvmtodo.data

import android.text.format.DateFormat

data class LocationWeatherData(
    val name: String,
    val region: String,
    val country: String,
    val localtime: DateFormat
) {
}