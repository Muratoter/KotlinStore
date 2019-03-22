package com.moter.mvvm.di

import com.moter.mvvm.services.PostService
import com.moter.mvvm.services.RetrofitClient
import com.moter.mvvm.view.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val retrofit = RetrofitClient.createInstance()
private val postService = retrofit.create(PostService::class.java)
val appModule = module {
    single { postService }
    viewModel { MainViewModel(get()) }
}