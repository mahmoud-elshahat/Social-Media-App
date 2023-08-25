package com.example.social_media_app.domain.usecase

import com.example.social_media_app.data.dto.response.toPost
import com.example.social_media_app.domain.model.Post
import com.example.social_media_app.domain.repository.PostsRepository
import javax.inject.Inject

class PostsListUseCase @Inject constructor(private val postsRepository: PostsRepository) {
    suspend fun getPostsList(): List<Post> {
        val postsDtoList = postsRepository.getPostsFromRemote()
        return postsDtoList.map { it.toPost() }
    }
}