plugins {
    alias(libs.plugins.myscore.android.library)
    alias(libs.plugins.myscore.android.hilt)
    id("kotlinx-serialization")
}

android {
    namespace = "com.zm.myscore.core.network"

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(projects.core.common)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)

    testImplementation(projects.core.testing)
}