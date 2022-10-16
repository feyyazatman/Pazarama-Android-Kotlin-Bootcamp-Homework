package com.feyyazatman.week4_homework.data.api

import com.feyyazatman.week4_homework.data.model.WeatherX
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("onecall")
    fun getDailyWeather(
        @Query("lat") latitude: String ,
        @Query("lon") longitude : String,
        @Query("units") units : String,
    ) : Call<WeatherX>
}