plugins {
    alias(libs.plugins.myscore.android.library)
    kotlin("kapt")
}

android {
    namespace = "com.zm.myscore.core.domain"
}

dependencies {
    implementation(projects.core.data)
    implementation(projects.core.model)
    implementation(libs.hilt.android)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.datetime)

    kapt(libs.hilt.compiler)

    testImplementation(projects.core.testing)
}