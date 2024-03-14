package com.zm.myscore.core.data.repository

import com.zm.myscore.core.model.Country
import kotlinx.coroutines.flow.Flow

interface CountryRepository {
    fun getCountries(): Flow<List<Country>>
}