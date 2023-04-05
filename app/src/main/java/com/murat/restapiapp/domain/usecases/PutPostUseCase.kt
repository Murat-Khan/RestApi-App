package com.murat.restapiapp.domain.usecases

import com.murat.restapiapp.data.PostRepository
import com.murat.restapiapp.data.api.model.PostResponse
import javax.inject.Inject

class PutPostUseCase @Inject constructor(private val postRepository: PostRepository){

    suspend fun invoke(id: String,body: PostResponse) = postRepository.putPosts(id = id,body= body)
}