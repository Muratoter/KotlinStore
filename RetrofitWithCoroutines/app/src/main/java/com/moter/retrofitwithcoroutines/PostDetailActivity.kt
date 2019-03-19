package com.moter.retrofitwithcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.moter.retrofitwithcoroutines.services.PostService
import com.moter.retrofitwithcoroutines.services.RetrofitClient
import kotlinx.android.synthetic.main.activity_post_detail.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PostDetailActivity : AppCompatActivity() {
    lateinit var postService: PostService
    private var postId: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)

        val retrofit = RetrofitClient.instance
        postService = retrofit.create(PostService::class.java)


        postId = intent?.extras?.getInt("postId")

        getPost()
    }

    fun getPost() {
        GlobalScope.launch(Dispatchers.Main) {
            val post = postService.getPost(postId!!).await()
            tvPostDetail.text = post.toString()
        }
    }
}
