plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.dk.dagger2retrofitcoroutines"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.dk.dagger2retrofitcoroutines"
        minSdk = 31
        targetSdk = 33
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
        freeCompilerArgs = listOf("-Xjvm-default=enable")
    }
    kapt {
        generateStubs = true
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    // Dagger2
    api ("com.google.dagger:dagger:2.24")
    api ("com.google.dagger:dagger-android:2.24")
    api ("com.google.dagger:dagger-android-support:2.24")

    annotationProcessor ("com.google.dagger:dagger-compiler:2.24")
    kapt ("com.google.dagger:dagger-compiler:2.24")

    annotationProcessor ("com.google.dagger:dagger-android-processor:2.24")
    kapt ("com.google.dagger:dagger-android-processor:2.24")
    //ViewModel and LiveData
    val lifecycle_version = "2.5.1"
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    //Retrofit
    val retrofit_version = "2.9.0"
    implementation ("com.squareup.retrofit2:retrofit:$retrofit_version")
    // GSON
    implementation ("com.squareup.retrofit2:converter-gson:$retrofit_version")
    // Room
    implementation("androidx.room:room-runtime:2.4.3")
    implementation("androidx.room:room-ktx:2.4.3")
    kapt("androidx.room:room-compiler:2.4.3")
    //coroutines
    val coroutines_version = "1.6.4"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}