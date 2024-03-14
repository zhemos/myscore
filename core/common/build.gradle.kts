plugins {
    alias(libs.plugins.myscore.android.library)
    alias(libs.plugins.myscore.android.hilt)
}

android {
    namespace = "com.zm.myscore.core.common"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
    testImplementation(projects.core.testing)
}