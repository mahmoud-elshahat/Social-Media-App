package com.example.social_media_app.data.network

sealed class ResponseResult<out H> {
    data class Success<out T>(val data: T)
        : ResponseResult<T>()
    data class Failure(val error: Throwable)
        : ResponseResult<Nothing>()
    object Loading : ResponseResult<Nothing>()
}