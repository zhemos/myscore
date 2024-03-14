package com.zm.myscore.core.testing.repository

import com.zm.myscore.core.data.repository.CountryRepository
import com.zm.myscore.core.model.Country
import kotlinx.coroutines.flow.Flow

class TestCountryRepository : CountryRepository {
    override fun getCountries(): Flow<List<Country>> {
        TODO("Not yet implemented")
    }
}