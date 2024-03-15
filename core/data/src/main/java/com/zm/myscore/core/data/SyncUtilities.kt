package com.zm.myscore.core.data

interface Synchronizer {}

interface Syncable {
    suspend fun syncWith(synchronizer: Synchronizer): Boolean
}