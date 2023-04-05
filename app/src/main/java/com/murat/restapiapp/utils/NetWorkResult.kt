package com.murat.restapiapp.utils

sealed class NetWorkResult<T>(
    val data: T? = null,
    val message: String? = null,
) {
    class Success<T>(data: T?):NetWorkResult<T>(data)
    class Error<T>(data: T?,message: String?): NetWorkResult<T>(data,message)
    class Loading<T>():NetWorkResult<T>()
}
