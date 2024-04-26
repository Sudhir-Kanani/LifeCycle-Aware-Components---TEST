package com.ads.datae.Retrofit_Coroutine_MVVM_ROOM


open class Response<T>(val data : T?=null, val error: String?=null) {
    class Loading<T>:Response<T>()
    class Sucess<T>(data: T?):Response<T>(data = data)
    class Error<T>(error: String?):Response<T>(error = error)
}