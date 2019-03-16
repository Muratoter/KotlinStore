package com.moter.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.moter.retrofit.model.Post
import com.moter.retrofit.services.PostService
import com.moter.retrofit.services.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    lateinit var postService: PostService
    lateinit var mDisposable: CompositeDisposable
    lateinit var post: Post
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val retrofit = RetrofitClient.instance
        postService = retrofit.create(PostService::class.java)
        mDisposable = CompositeDisposable()

        post = intent.getParcelableExtra<Post>("post")
        fetchData()
    }

    private fun fetchData() {
        mDisposable.add(
            postService.getPost(post.id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::displayPost, this::fetchError)
        )
    }

    private fun displayPost(post: Post) {
        tvPostDetail.text=post.toString()
    }

    private fun fetchError(throwable: Throwable) {
        Log.e("DetailActivity", "data fetching error: ${throwable.message}")
    }
}
