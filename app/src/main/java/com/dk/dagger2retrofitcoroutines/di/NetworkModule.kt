package com.dk.dagger2retrofitcoroutines.di

import com.dk.dagger2retrofitcoroutines.retrofit.FakeAPI
import com.dk.dagger2retrofitcoroutines.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesFakerApi(retrofit: Retrofit): FakeAPI{
        return retrofit.create(FakeAPI::class.java)
    }
}