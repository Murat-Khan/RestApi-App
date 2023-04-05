package com.murat.restapiapp.domain.usecases

import com.murat.restapiapp.data.PostRepository
import javax.inject.Inject

class DeletePostUseCase @Inject constructor(private val postRepository: PostRepository) {

    suspend fun invoke(id: String) = postRepository.deletePosts(id = id)
}