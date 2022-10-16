package com.feyyazatman.week4_homework.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Current(
    @SerializedName("clouds")
    val clouds: Int?,
    @SerializedName("dew_point")
    val dewPoint: Double?,
    @SerializedName("dt")
    val dt: Int?,
    @SerializedName("feels_like")
    val feelsLike: Double?,
    @SerializedName("humidity")
    val humidity: Double?,
    @SerializedName("pressure")
    val pressure: Double?,
    @SerializedName("sunrise")
    val sunrise: Double?,
    @SerializedName("sunset")
    val sunset: Double?,
    @SerializedName("temp")
    val temp: Double?,
    @SerializedName("uvi")
    val uvi: Double?,
    @SerializedName("visibility")
    val visibility: Double?,
    @SerializedName("weather")
    val weather: List<Weather?>?,
    @SerializedName("wind_deg")
    val windDeg: Double?,
    @SerializedName("wind_speed")
    val windSpeed: Double?
) : Parcelable