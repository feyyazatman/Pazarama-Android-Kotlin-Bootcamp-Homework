package com.feyyazatman.week4_homework.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FeelsLike(
    @SerializedName("day")
    val day: Double?,
    @SerializedName("eve")
    val eve: Double?,
    @SerializedName("morn")
    val morn: Double?,
    @SerializedName("night")
    val night: Double?
) : Parcelable