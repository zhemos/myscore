package com.zm.myscore.core.network.fake

import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals


class FakeMyScoreNetworkDataSourceTest {

    private lateinit var subject: FakeMyScoreNetworkDataSource

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        subject = FakeMyScoreNetworkDataSource(
            networkJson = Json { ignoreUnknownKeys = true },
        )
    }

    @Test
    fun testCountries() = runTest(testDispatcher) {
        val expected = listOf<String>()
        assertEquals(expected, subject.getCountries())
    }
}