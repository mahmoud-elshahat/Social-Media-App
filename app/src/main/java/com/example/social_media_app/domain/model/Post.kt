package com.example.social_media_app.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Post(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
) : Parcelable