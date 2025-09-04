package com.livedatasexample.di

import com.livedatasexample.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    //fun baseUrl(): String = "https://meme-api.com/"
   // fun baseUrl(): String = "https://jsonplaceholder.typicode.com/"
    fun baseUrl(): String = "https://dog.ceo/api/breeds/image/"

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit : Retrofit) : ApiService = retrofit.create(ApiService::class.java)
}