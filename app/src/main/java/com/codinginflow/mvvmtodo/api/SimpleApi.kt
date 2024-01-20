package com.codinginflow.mvvmtodo.api

import com.codinginflow.mvvmtodo.data.Post
import com.codinginflow.mvvmtodo.ui.WEATHER_API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface SimpleApi {

    @GET("/v1/current.json?key=$WEATHER_API_KEY&q=Arzamas&aqi=no")
    suspend fun getPost(): Response<Post>

    @GET("/v1/current.json")
    suspend fun getWeatherInCity(
        @Query("key") key: String,
        @QueryMap options: Map<String, String>
    ): Response<Post>

    @GET("/v1/current.json")
    suspend fun getCustomWeather(
        @Query("key=$WEATHER_API_KEY&aqi=no&q=") name: String
    ): Response<Post>

    @GET("/v1/current.json")
    suspend fun getCustomWeatherFullPath(
        @Query("key") key: String,
        @Query("q") name: String,
        @Query("aqi") aqi: String // yes/no
    ): Response<Post>


}