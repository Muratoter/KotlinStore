package com.moter.retrofitwithcoroutines.services


import com.moter.retrofitwithcoroutines.model.Post
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface PostService {

    @GET("posts")
    fun getPost(): Deferred<Response<List<Post>>>

    @GET("posts/{id}")
    fun getPost(@Path("id") id: Int): Deferred<Post>

}