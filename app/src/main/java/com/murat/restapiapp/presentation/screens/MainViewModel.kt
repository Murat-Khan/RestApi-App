package com.murat.restapiapp.presentation.screens

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.murat.restapiapp.data.api.model.PostResponse
import com.murat.restapiapp.domain.usecases.*
import com.murat.restapiapp.utils.NetWorkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val deletePostUseCase: DeletePostUseCase,
    private val getAllPostsUseCase: GetAllPostsUseCase,
    private val patchPostUseCase: PatchPostUseCase,
    private val postUseCase: PostPostUseCase,
    private val putPostUseCase: PutPostUseCase
) : ViewModel() {
    private val _allPostsResponse = MediatorLiveData<NetWorkResult<List<PostResponse>>>()
    val allPostResponse: LiveData<NetWorkResult<List<PostResponse>>>
        get() = _allPostsResponse

    init {
        getAllPosts()
    }

    fun getAllPosts() {
        viewModelScope.launch {
            getAllPostsUseCase.invoke().let {
                _allPostsResponse.value = it
            }
        }
    }

    fun postPosts() {
        viewModelScope.launch {
            postUseCase.invoke(body = PostResponse(title = "Test title", body = "Test body"))
        }
    }

    fun putPost() {
        viewModelScope.launch {
            putPostUseCase.invoke(
                id = "1",
                body = PostResponse(title = "Test title", body = "Test body")
            ).let {
                Log.d("checkData", "data${it.data}")
            }
        }
    }

    fun patchPost() {
        viewModelScope.launch {
            patchPostUseCase.invoke(
                id = "1",
                body = PostResponse(title = "Test title", body = "Test body")
            ).let {
                Log.d("checkData", "data${it.data}")
            }
        }
    }

    fun deletePost() {
        viewModelScope.launch {
            deletePostUseCase.invoke(id = "1").let {
                Log.d("checkData", "data${it.data}")
            }
        }
    }

}