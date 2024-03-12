package com.zm.myscore.core.network

interface MyScoreNetworkDataSource {
    suspend fun getCountries(): List<String>
}