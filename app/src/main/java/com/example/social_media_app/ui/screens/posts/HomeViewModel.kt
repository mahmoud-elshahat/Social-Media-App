package com.example.social_media_app.ui.screens.posts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.social_media_app.data.network.ResponseResult
import com.example.social_media_app.data.network.safeApiCall
import com.example.social_media_app.domain.model.Post
import com.example.social_media_app.domain.usecase.PostsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val postsListUseCase: PostsListUseCase) :
    ViewModel() {
    private val _postsListResponse =
        MutableLiveData<ResponseResult<List<Post>>?>(ResponseResult.Loading)
    val postsListResponse = _postsListResponse

    fun retrievePosts() {
        if (_postsListResponse.value !is ResponseResult.Success)
            viewModelScope.launch {
                _postsListResponse.value = safeApiCall { postsListUseCase.getPostsList() }
            }
    }
}