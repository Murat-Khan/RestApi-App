package com.murat.restapiapp.domain.usecases

import com.murat.restapiapp.data.PostRepository
import javax.inject.Inject

class GetAllPostsUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend fun invoke() = postRepository.getAllPosts()
}