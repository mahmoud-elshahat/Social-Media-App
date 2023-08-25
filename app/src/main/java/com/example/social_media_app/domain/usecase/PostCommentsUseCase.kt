package com.example.social_media_app.domain.usecase

import com.example.social_media_app.data.dto.response.toComment
import com.example.social_media_app.domain.model.Comment
import com.example.social_media_app.domain.repository.PostsRepository
import javax.inject.Inject

class PostCommentsUseCase @Inject constructor(private val postsRepository: PostsRepository) {
    suspend fun getPostComments(postId:String): List<Comment> {
        val postsDtoList = postsRepository.getPostComments(postId)
        return postsDtoList.map { it.toComment() }
    }
}