package com.zm.myscore.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class CountryDto(
    val name: String? = null,
    val code: String? = null,
    val flag: String? = null,
)