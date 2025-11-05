package com.example.worldexplorer.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Countries(
    @SerializedName("capital")
    val capital: List<String?>?,
    @SerializedName("flags")
    val flags: Flags?,
    @SerializedName("name")
    val name: Name?,
    @SerializedName("population")
    val population: Int?,
    @SerializedName("region")
    val region: String?
)