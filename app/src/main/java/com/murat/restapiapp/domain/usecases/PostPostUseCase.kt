package com.murat.restapiapp.domain.usecases

import com.murat.restapiapp.data.PostRepository
import com.murat.restapiapp.data.api.model.PostResponse
import okhttp3.ResponseBody
import javax.inject.Inject

class PostPostUseCase @Inject constructor(private val postRepository: PostRepository) {

    suspend fun invoke(body: PostResponse) = postRepository.postPosts(body)

}