plugins {
    alias(libs.plugins.myscore.android.library)
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

    testImplementation(projects.core.testing)
}