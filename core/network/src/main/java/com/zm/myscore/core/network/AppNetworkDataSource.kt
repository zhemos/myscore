package com.zm.myscore.core.network

import com.zm.myscore.core.network.model.CountryDto
import com.zm.myscore.core.network.model.ResultWrapperDto

interface AppNetworkDataSource {
    suspend fun getCountries(): ResultWrapperDto<List<CountryDto>>

    suspend fun getCountriesSimply(): List<CountryDto>
}