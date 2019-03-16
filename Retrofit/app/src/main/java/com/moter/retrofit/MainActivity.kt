package com.moter.retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.moter.retrofit.adapter.PostAdapter
import com.moter.retrofit.model.Post
import com.moter.retrofit.services.PostService
import com.moter.retrofit.services.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PostAdapter.ItemListener {

    lateinit var postService: PostService
    lateinit var mDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = RetrofitClient.instance
        postService = retrofit.create(PostService::class.java)
        mDisposable = CompositeDisposable()

        rvPostList.setHasFixedSize(true)
        rvPostList.layoutManager = LinearLayoutManager(this)
        fetchData()

    }

    private fun fetchData() {
        mDisposable.add(
            postService.getPost().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::displayPost, this::fetchError)
        )
    }

    private fun displayPost(pList: List<Post>) {
        val postAdapter = PostAdapter(applicationContext, pList, this)
        rvPostList.adapter = postAdapter
    }

    private fun fetchError(throwable: Throwable) {
        Log.e("MainActivity", "fetch error: ${throwable.message}")
    }

    override fun itemClicked(post: Post) {

        val detailIntent = Intent(this, DetailActivity::class.java)
        detailIntent.putExtra("post", post)
        startActivity(detailIntent)

    }

    override fun onDestroy() {
        super.onDestroy()
        mDisposable.clear()
    }

}
