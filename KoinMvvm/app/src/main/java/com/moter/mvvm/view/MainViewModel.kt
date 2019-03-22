package com.moter.mvvm.view

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.moter.mvvm.model.Post
import com.moter.mvvm.services.PostService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainViewModel(private val postService: PostService) : ViewModel() {
    private val posts = MutableLiveData<List<Post>>()

    init {
        Log.d("MainViewModel","init")
    }
    fun getPost(): MutableLiveData<List<Post>> {
        return posts
    }

    fun loadPost() {
        GlobalScope.launch(Dispatchers.Main) {
            val response = postService.getPost().await()
            if (response.isSuccessful) {
                posts.value = response.body()
            }
        }
    }

}