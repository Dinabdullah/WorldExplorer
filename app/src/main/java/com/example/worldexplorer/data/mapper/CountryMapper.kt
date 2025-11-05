package com.example.worldexplorer.data.mapper

import com.example.worldexplorer.data.remote.dto.AraDto
import com.example.worldexplorer.data.remote.dto.CountryDto
import com.example.worldexplorer.data.remote.dto.FlagsDto
import com.example.worldexplorer.data.remote.dto.NameDto
import com.example.worldexplorer.data.remote.dto.NativeNameDto

import com.example.worldexplorer.domain.entites.Ara
import com.example.worldexplorer.domain.entites.Country
import com.example.worldexplorer.domain.entites.Flags
import com.example.worldexplorer.domain.entites.Name
import com.example.worldexplorer.domain.entites.NativeName

fun AraDto.toDomain():Ara{
    return Ara(
        common = common,
        official = official
    )
}

fun CountryDto.toDomain():Country{
    return Country(
        capital = capital,
        flags = flags?.toDomain(),
        name = name?.toDomain(),
        population = population,
        region = region
    )
}

fun FlagsDto.toDomain():Flags{
    return Flags(
        alt = alt,
        png = png,
        svg = svg
    )
}

fun NameDto.toDomain():Name{
    return Name(
        common = common,
        nativeName = nativeName?.toDomain(),
        official = official
    )
}

fun NativeNameDto.toDomain():NativeName{
    return NativeName(
        ara = ara?.toDomain()
    )
}
