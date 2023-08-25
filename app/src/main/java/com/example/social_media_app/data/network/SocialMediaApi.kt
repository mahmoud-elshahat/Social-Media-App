package com.example.social_media_app.data.network

import com.example.social_media_app.data.dto.response.PostDto
import retrofit2.http.GET

interface SocialMediaApi {
    @GET(Constants.POSTS_URL)
    suspend fun getPostsList(): ArrayList<PostDto>
}