package com.zm.myscore.core.network.fake

import JvmUnitTestFakeAssetManager
import com.zm.myscore.core.common.network.AppDispatchers
import com.zm.myscore.core.common.network.Dispatcher
import com.zm.myscore.core.network.AppNetworkDataSource
import com.zm.myscore.core.network.model.CountryDto
import com.zm.myscore.core.network.model.ResultWrapperDto
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream

class FakeAppNetworkDataSource(
    @Dispatcher(AppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
    private val networkJson: Json,
    private val assets: FakeAssetManager = JvmUnitTestFakeAssetManager,
) : AppNetworkDataSource {

    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun getCountries(): ResultWrapperDto<List<CountryDto>> {
        return assets.open(COUNTRIES_ASSET).use(networkJson::decodeFromStream)
    }

    companion object {
        private const val COUNTRIES_ASSET = "countries.json"
    }
}