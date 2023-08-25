package com.example.social_media_app.ui.screens.post_details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.social_media_app.data.network.ResponseResult
import com.example.social_media_app.data.network.safeApiCall
import com.example.social_media_app.domain.model.Comment
import com.example.social_media_app.domain.usecase.PostCommentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor(private val postCommentsUseCase: PostCommentsUseCase) :
    ViewModel() {
    private val _postsCommentsResponse =
        MutableLiveData<ResponseResult<List<Comment>>?>(ResponseResult.Loading)
    val postsCommentsResponse = _postsCommentsResponse

    fun retrieveComments(postId: String) {
        viewModelScope.launch {
            _postsCommentsResponse.value =
                safeApiCall { postCommentsUseCase.getPostComments(postId) }
        }
    }
}