plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.zm.myscore.core.testing"
    compileSdk = 34
}

dependencies {
    api(libs.junit4)
    api(libs.kotlinx.coroutines.test)
}