package com.zm.myscore.core.network.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.zm.myscore.core.network.AppNetworkDataSource
import com.zm.myscore.core.network.model.CountryDto
import com.zm.myscore.core.network.model.ResultWrapperDto
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import javax.inject.Inject
import javax.inject.Singleton

private interface RetrofitAppNetworkApi {
    @GET("v3/countries")
    suspend fun getCountries(): ResultWrapperDto<List<CountryDto>>
}

private const val APP_BASE_URL = "https://api-football-v1.p.rapidapi.com"

@Singleton
class RetrofitAppNetwork @Inject constructor(
    networkJson: Json,
    okhttpCallFactory: Call.Factory,
) : AppNetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl(APP_BASE_URL)
        .callFactory(okhttpCallFactory)
        .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
        .build()
        .create(RetrofitAppNetworkApi::class.java)

    override suspend fun getCountries(): ResultWrapperDto<List<CountryDto>> {
        return networkApi.getCountries()
    }

    override suspend fun getCountriesSimply(): List<CountryDto> {
        return networkApi.getCountries().data ?: emptyList()
    }
}