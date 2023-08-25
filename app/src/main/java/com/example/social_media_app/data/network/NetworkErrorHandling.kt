package com.example.social_media_app.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend inline fun <T> safeApiCall(
    crossinline body: suspend () -> T
): ResponseResult<T> {
    return try {
        val data = withContext(Dispatchers.IO) {
            body() }
        ResponseResult.Success(data)
    } catch (e: Exception) {
        ResponseResult.Failure(e)
    }
}