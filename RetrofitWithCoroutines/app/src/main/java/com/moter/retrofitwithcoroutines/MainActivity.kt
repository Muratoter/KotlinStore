package com.moter.retrofitwithcoroutines

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.moter.retrofitwithcoroutines.adapter.PostAdapter
import com.moter.retrofitwithcoroutines.model.Post
import com.moter.retrofitwithcoroutines.services.PostService
import com.moter.retrofitwithcoroutines.services.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), PostAdapter.ItemListener {


    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)

    lateinit var postService: PostService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = RetrofitClient.instance
        postService = retrofit.create(PostService::class.java)

        rvPostList.setHasFixedSize(true)
        rvPostList.layoutManager = LinearLayoutManager(this)
        fetchData()
    }

    fun fetchData() {
        scope.launch {
            val response = postService.getPost().await()
            if (response.isSuccessful) {
                val postList: List<Post>? = response.body()
                displayPost(postList!!)
            }
        }
    }

    private fun displayPost(pList: List<Post>) {
        val postAdapter = PostAdapter(applicationContext, pList, this)
        rvPostList.adapter = postAdapter
    }

    override fun itemClicked(post: Post) {
        val detailActivity = Intent(applicationContext, PostDetailActivity::class.java)
        detailActivity.putExtra("postId", post.id)
        startActivity(detailActivity)
    }

}
