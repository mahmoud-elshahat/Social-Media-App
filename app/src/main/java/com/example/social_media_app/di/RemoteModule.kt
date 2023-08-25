package com.example.social_media_app.di

import android.util.Log
import com.example.social_media_app.data.network.Constants.BASE_URL
import com.example.social_media_app.data.network.SocialMediaApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    private const val TAG = "API-LOGS"

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor { message: String ->
            Log.d(TAG, message)
        }
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                val originalHttpUrl = chain.request().url
                val url = originalHttpUrl.newBuilder().build()
                request.url(url)
                return@addInterceptor chain.proceed(request.build())
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideSocialMediaApi(okHttpClient: OkHttpClient): SocialMediaApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SocialMediaApi::class.java)
    }
}