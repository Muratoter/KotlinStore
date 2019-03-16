package com.moter.retrofit.services


import com.moter.retrofit.model.Post
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface PostService {
    @GET("posts")
    fun getPost(): Observable<List<Post>>

    @GET("posts/{id}")
    fun getPost(@Path("id") id: Int): Observable<Post>

    @POST("posts")
    fun addPost(@Body post: Post)
}