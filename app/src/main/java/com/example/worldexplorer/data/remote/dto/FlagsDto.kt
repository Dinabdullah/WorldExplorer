package com.example.worldexplorer.data.remote.dto

import com.google.gson.annotations.SerializedName

data class FlagsDto(
    @SerializedName("alt")
    val alt: String?,
    @SerializedName("png")
    val png: String?,
    @SerializedName("svg")
    val svg: String?
)