package com.example.social_media_app.data.repository

import com.example.social_media_app.data.dto.response.PostDto
import com.example.social_media_app.data.network.SocialMediaApi
import com.example.social_media_app.domain.repository.PostsRepository

class PostsRepositoryImpl(private val socialMediaApi: SocialMediaApi) : PostsRepository {
    override suspend fun getPostsFromRemote(): ArrayList<PostDto> {
        return socialMediaApi.getPostsList()
    }
}