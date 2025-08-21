package com.livedatasexample.utils

sealed class ApiResponseCallBack<T> {

    class Loading<T> : ApiResponseCallBack<T>()
    class Error<T>(val message : String) : ApiResponseCallBack<T>()
    class Success<T>(val data : T) : ApiResponseCallBack<T>()

    companion object {
        fun<T> loading() = Loading<T>()
        fun<T> error(message: String) = Error<T>(message)
        fun<T> success(data :T) = Success<T>(data)
    }
}