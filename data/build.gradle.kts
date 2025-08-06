plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)

    id("com.google.devtools.ksp")  //Kotlin Symbol Processing
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.loaizasoftware.data"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    // ------------------------------------------------------
    // 📦 MODULE DEPENDENCIES
    // ------------------------------------------------------

    implementation(project(":domain"))


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // ------------------------------------------------------
    // 🔐 DEPENDENCY INJECTION
    // ------------------------------------------------------

    //Hilt
    implementation("com.google.dagger:hilt-android:2.56.2")
    ksp("com.google.dagger:hilt-android-compiler:2.56.2")

    // ------------------------------------------------------
    // 🌐 NETWORKING
    // ------------------------------------------------------

    implementation("com.squareup.retrofit2:retrofit:3.0.0") // Retrofit
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2") // Show retrofit logs

    //---- Deserialization -----//

    //Moshi
    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.15.2")
    implementation("com.squareup.moshi:moshi:1.15.2")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.15.0")


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}