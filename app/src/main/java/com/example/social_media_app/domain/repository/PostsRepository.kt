package com.example.social_media_app.domain.repository

import com.example.social_media_app.data.dto.response.CommentDto
import com.example.social_media_app.data.dto.response.PostDto

interface PostsRepository {
    suspend fun getPostsFromRemote(): ArrayList<PostDto>

    suspend fun getPostComments(postId:String): ArrayList<CommentDto>
}