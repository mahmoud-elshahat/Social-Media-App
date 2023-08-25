package com.example.social_media_app.di

import com.example.social_media_app.data.network.SocialMediaApi
import com.example.social_media_app.data.repository.PostsRepositoryImpl
import com.example.social_media_app.domain.repository.PostsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun providePostsRepository(socialMediaApi: SocialMediaApi): PostsRepository {
        return PostsRepositoryImpl(socialMediaApi)
    }
}