package com.example.worldexplorer.data.remote.dto

import com.google.gson.annotations.SerializedName

data class AraDto(
    @SerializedName("common")
    val common: String?,
    @SerializedName("official")
    val official: String?
)