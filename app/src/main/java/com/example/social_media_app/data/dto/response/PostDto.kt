package com.example.social_media_app.data.dto.response

import com.example.social_media_app.domain.model.Post
import com.google.gson.annotations.SerializedName

data class PostDto(
    val body: String,
    val id: Int,
    val title: String,
    @SerializedName("user_id")
    val userId: Int
)

fun PostDto.toPost(): Post {
    return Post(
        body = body,
        id = id,
        title = title,
        userId = userId
    )
}