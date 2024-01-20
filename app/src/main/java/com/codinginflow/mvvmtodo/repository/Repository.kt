package com.codinginflow.mvvmtodo.repository

import com.codinginflow.mvvmtodo.api.RetrofitInstance
import com.codinginflow.mvvmtodo.data.Post
import retrofit2.Response

class Repository {

    suspend fun getWeatherInCity(
        key: String,
        options: Map<String, String>
    ): Response<Post> {
        return RetrofitInstance.api.getWeatherInCity(key, options)
    }
}