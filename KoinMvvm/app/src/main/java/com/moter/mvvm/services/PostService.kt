package com.moter.mvvm.services

import com.moter.mvvm.model.Post
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface PostService {
    @GET("posts")
    fun getPost(): Deferred<Response<List<Post>>>
}