package com.murat.restapiapp.utils

import retrofit2.Response

abstract class BaseApiResponse {
    suspend fun <T> safeApiCall(api: suspend () -> Response<T>): NetWorkResult<T> {

        try {
            val response = api()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return NetWorkResult.Success(body)
                } ?: return errorMessage("Body is empty")

            } else {
                return errorMessage("${response.code()} ${response.message()}")
            }

        } catch (e: Exception) {
            return errorMessage(e.message.toString())
        }

    }

    private fun <T> errorMessage(e: String): NetWorkResult.Error<T> =
        NetWorkResult.Error(data = null, message = "Api failure${e}")
}