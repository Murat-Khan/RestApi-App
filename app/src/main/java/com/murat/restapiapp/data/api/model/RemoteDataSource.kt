package com.murat.restapiapp.data.api.model

import com.murat.restapiapp.data.api.PostService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val postService: PostService) {

    suspend fun getAllPost() = postService.getAllPosts()
    suspend fun postPosts(body:PostResponse) = postService.postPost(body = body)
    suspend fun putPosts(id:String,body: PostResponse) = postService.putPost(id = id,body = body)
    suspend fun patchPosts(id:String,body: PostResponse) = postService.patchPost(id = id,body = body)
    suspend fun deletePosts(id:String) = postService.deletePost(id = id)
}