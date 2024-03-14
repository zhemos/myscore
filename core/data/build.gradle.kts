plugins {
    alias(libs.plugins.myscore.android.library)
    alias(libs.plugins.myscore.android.hilt)
    id("kotlinx-serialization")
}

android {
    namespace = "com.zm.myscore.core.data"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.network)
    implementation(projects.core.model)
    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)

    testImplementation(projects.core.testing)
}