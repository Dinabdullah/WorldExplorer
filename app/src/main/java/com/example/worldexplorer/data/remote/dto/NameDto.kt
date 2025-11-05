package com.example.worldexplorer.data.remote.dto

import com.google.gson.annotations.SerializedName

data class NameDto(
    @SerializedName("common")
    val common: String?,
    @SerializedName("nativeName")
    val nativeName: NativeNameDto?,
    @SerializedName("official")
    val official: String?
)