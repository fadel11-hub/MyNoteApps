plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.devtools.ksp") version "1.9.0-1.0.11" apply true // Dengan asumsi versi Kotlin 1.9.0
}

android {
    namespace = "com.example.mynoteapps"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mynoteapps"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    // Update ke Java 1.7 untuk kompatibilitas yang lebih baik dengan library modern
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_7
        targetCompatibility = JavaVersion.VERSION_1_7
    }

    kotlinOptions {
        jvmTarget = "1.7"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Tambahkan dependensi Glide untuk memuat gambar
    implementation("com.github.bumptech.glide:glide:4.16.0")

    // Tambahkan dependensi Retrofit untuk permintaan jaringan
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    // Standar library Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Material design
    implementation("com.google.android.material:material:1.12.0")

//   Lifecylemodel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.livedata.ktx)


    // Room dependencies
    implementation(libs.androidx.room.runtime)
    ksp(libs.room.compiler)


}
