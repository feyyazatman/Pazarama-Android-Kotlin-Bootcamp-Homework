package com.feyyazatman.week4_homework.ui.weather

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.feyyazatman.week4_homework.data.api.ApiClient
import com.feyyazatman.week4_homework.data.model.WeatherX
import com.feyyazatman.week4_homework.databinding.FragmentWeatherBinding
import com.feyyazatman.week4_homework.ui.weather.adapter.WeatherAdapter
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback


class WeatherFragment : Fragment() {

    // define viewbinding
    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeatherBinding.inflate(inflater,container,false) // inflate binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDailyWeather()
    }


    // get api data
    private fun getDailyWeather() {
        ApiClient.getApiService().getDailyWeather("40.78","30.40","metric").enqueue(object : Callback<WeatherX> {
            override fun onResponse(call: Call<WeatherX>, response: Response<WeatherX>) {
                Log.d("WeatherFragment", response.body().toString())

                if (response.isSuccessful) {
                    val weather = response.body()
                    weather?.let { weatherX ->
                        binding.rvWeather.adapter = WeatherAdapter { daily ->
                            val action = WeatherFragmentDirections.actionWeatherFragmentToDetailFragment(daily)
                            findNavController().navigate(action)
                        }.apply {
                            submitList(weatherX.daily)
                        }
                        Log.d("WeatherFragment", weatherX.daily?.get(0)?.weather?.get(0)?.description.toString())
                    }
                }
            }

            override fun onFailure(call: Call<WeatherX>, t: Throwable) {
                Log.d("WeatherFragment", t.toString())
            }
        })
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}