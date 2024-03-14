package com.zm.myscore.core.network.fake

import com.zm.myscore.core.network.model.CountryDto
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class FakeAppNetworkDataSourceTest {

    private lateinit var subject: FakeAppNetworkDataSource

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        subject = FakeAppNetworkDataSource(
            ioDispatcher = testDispatcher,
            networkJson = Json { ignoreUnknownKeys = true },
        )
    }

    @Test
    fun testDeserializationOfCountries() = runTest(testDispatcher) {
        val expected = CountryDto(
            name = "Albania",
            code = "AL",
            flag = "https://media.api-sports.io/flags/al.svg"
        )
        assertEquals(expected, subject.getCountries().data?.first())
    }
}