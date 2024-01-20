package com.codinginflow.mvvmtodo.ui.weather

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codinginflow.mvvmtodo.data.Post
import com.codinginflow.mvvmtodo.di.ApplicationScope
import com.codinginflow.mvvmtodo.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import retrofit2.Response

class WeatherViewModel @ViewModelInject constructor(
    private val repository: Repository,
    @ApplicationScope private val applicationScope: CoroutineScope
) : ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()

    fun getWeatherInCity(
        key: String,
        options: Map<String, String>
    ) {
        viewModelScope.launch {
            val response = repository.getWeatherInCity(key, options)
            myResponse.value = response
        }
    }
}