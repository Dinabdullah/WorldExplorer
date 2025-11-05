package com.example.worldexplorer.data.remote.dto

import com.google.gson.annotations.SerializedName

data class NativeNameDto(
    @SerializedName("ara")
    val ara: AraDto?
)