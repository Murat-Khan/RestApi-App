package com.murat.restapiapp.data

import com.murat.restapiapp.data.api.model.PostResponse
import com.murat.restapiapp.data.api.model.RemoteDataSource
import com.murat.restapiapp.utils.BaseApiResponse
import com.murat.restapiapp.utils.NetWorkResult
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource):BaseApiResponse() {

    suspend fun getAllPosts(): NetWorkResult<List<PostResponse>>{
        return safeApiCall { remoteDataSource.getAllPost() }
    }

    suspend fun postPosts(body: PostResponse):NetWorkResult <PostResponse>{
        return safeApiCall { remoteDataSource.postPosts(body = body) }
    }

    suspend fun patchPosts(id: String, body: PostResponse):NetWorkResult <PostResponse>{
        return safeApiCall { remoteDataSource.patchPosts(id = id,body=body)}
    }

    suspend fun deletePosts(id: String):NetWorkResult <PostResponse>{
        return safeApiCall { remoteDataSource.deletePosts(id = id)}
    }
    suspend fun putPosts(id: String, body: PostResponse):NetWorkResult <PostResponse>{
        return safeApiCall { remoteDataSource.putPosts(id = id,body=body)}
    }
}