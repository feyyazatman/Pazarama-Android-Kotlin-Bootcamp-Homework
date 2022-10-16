package com.feyyazatman.week4_homework.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Rain(
    @SerializedName("1h")
    val h: Double?
) : Parcelable