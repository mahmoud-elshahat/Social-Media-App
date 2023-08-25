package com.example.social_media_app.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Comment(
    val id: Int,
    val body: String,
    val name: String,
    val email: String
) : Parcelable