package com.zm.myscore.core.network.fake

import JvmUnitTestFakeAssetManager
import com.zm.myscore.core.network.MyScoreNetworkDataSource
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream

class FakeMyScoreNetworkDataSource(
    private val networkJson: Json,
    private val assets: FakeAssetManager = JvmUnitTestFakeAssetManager,
) : MyScoreNetworkDataSource {

    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun getCountries(): List<String> {
        return assets.open(COUNTRIES_ASSET).use(networkJson::decodeFromStream)
    }

    companion object {
        private const val COUNTRIES_ASSET = "countries.json"
    }
}