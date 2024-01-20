package com.codinginflow.mvvmtodo.ui.weather

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.codinginflow.mvvmtodo.R
import com.codinginflow.mvvmtodo.databinding.FragmentWeatherBinding
import com.codinginflow.mvvmtodo.ui.WEATHER_API_KEY
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_weather.*

@AndroidEntryPoint
class WeatherFragment : Fragment(R.layout.fragment_weather) {

    private val viewModel: WeatherViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentWeatherBinding.bind(view)

        viewModel.myResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                Log.d("Response", response.body()?.current?.temp_c.toString())
                text_view_weather.text = response.body()?.current?.temp_c.toString()
            } else {
                Log.e("Response", response.errorBody().toString())
                text_view_weather.text = response.code().toString()
            }
        })

        val options: HashMap<String, String> = HashMap()
        options["q"] = "Moscow"
        options["aqi"] = "no"

        binding.apply {
            fabGetWeather.setOnClickListener {
                viewModel.getWeatherInCity(WEATHER_API_KEY, options)
            }
        }
    }
}