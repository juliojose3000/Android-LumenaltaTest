package com.loaizasoftware.lumenaltatest.injection

import com.loaizasoftware.data.api.ApiClient
import com.loaizasoftware.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesApiService(): ApiService {
        return ApiClient().apiService;
    }

}