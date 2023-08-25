package com.example.social_media_app.data.dto.response

import com.example.social_media_app.domain.model.Comment
import com.google.gson.annotations.SerializedName

data class CommentDto(
    val id: Int,
    @SerializedName("post_id")
    val postId: String,
    val name: String,
    val email: String,
    val body: String,
)

fun CommentDto.toComment(): Comment {
    return Comment(
        body = body,
        id = id,
        name = name,
        email = email
    )
}