plugins {
    alias(libs.plugins.myscore.android.library)
    alias(libs.plugins.myscore.android.library.compose)
    alias(libs.plugins.myscore.android.hilt)
}

android {
    namespace = "com.zm.myscore.core.testing"
}

dependencies {
    api(libs.junit4)
    api(libs.kotlinx.coroutines.test)

    implementation(projects.core.common)
    implementation(projects.core.data)
    implementation(projects.core.designsystem)
    implementation(projects.core.domain)
    implementation(projects.core.model)
}