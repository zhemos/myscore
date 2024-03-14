package com.zm.myscore.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultWrapperDto<T>(
    val results: Int? = null,
    @SerialName("response") val data: T? = null,
    @SerialName("message") val errorMessage: String? = null,
)

fun <T> createSuccessResultWrapper(
    results: Int,
    data: T,
): ResultWrapperDto<T> {
    return ResultWrapperDto(results = results, data = data)
}

fun createFailResultWrapper(errorMessage: String): ResultWrapperDto<*> {
    return ResultWrapperDto<Any>(errorMessage = errorMessage)
}