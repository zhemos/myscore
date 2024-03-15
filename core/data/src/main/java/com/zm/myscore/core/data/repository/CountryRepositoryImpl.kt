package com.zm.myscore.core.data.repository

import com.zm.myscore.core.model.Country
import com.zm.myscore.core.network.AppNetworkDataSource
import kotlinx.coroutines.flow.Flow

class CountryRepositoryImpl(
    private val network: AppNetworkDataSource
) : CountryRepository {
    override fun getCountries(): Flow<List<Country>> {
        TODO("Not yet implemented")
    }
}