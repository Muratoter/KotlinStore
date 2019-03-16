package com.moter.retrofit.services


import com.moter.retrofit.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by moter on 16.03.2019.
 * Copyright © 2018 ElephantApps. All rights reserved.
 */
interface PostService {
    @GET("posts")
    fun getPost():Observable<List<Post>>
}