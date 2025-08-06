package com.loaizasoftware.data.api

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {

    private val BASE_URL = "https://backend-usershandlerapp.fly.dev/usershandlerapp/api/"
    lateinit var apiService: ApiService

    operator fun invoke() {

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory()) // Allows Moshi to handle Kotlin classes properly
            .build()

        // Create and configure the logging interceptor
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY // Logs request and response lines and their respective headers and bodies (if present)
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS) // Connection timeout
            .readTimeout(30, TimeUnit.SECONDS)    // Read timeout
            .writeTimeout(30, TimeUnit.SECONDS)   // Write timeout
            .build()

        apiService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi)) // Use Moshi converter to deserialize JSON responses
            .build()
            .create(ApiService::class.java)

    }

}