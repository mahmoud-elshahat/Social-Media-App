package com.example.social_media_app.data.network

import com.example.social_media_app.data.dto.response.CommentDto
import com.example.social_media_app.data.dto.response.PostDto
import retrofit2.http.GET
import retrofit2.http.Path

interface SocialMediaApi {
    @GET(Constants.POSTS_URL)
    suspend fun getPostsList(): ArrayList<PostDto>

    @GET(Constants.COMMENTS_URL)
    suspend fun getPostComments(@Path(Constants.POST_ID) postId: String): ArrayList<CommentDto>
}