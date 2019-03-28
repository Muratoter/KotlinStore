package com.moter.firestore.di

import com.google.firebase.firestore.FirebaseFirestore
import com.moter.firestore.db.firestore.DatabaseRepo
import com.moter.firestore.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    single { DatabaseRepo(firestore = FirebaseFirestore.getInstance()) }
    viewModel { MainViewModel(get()) }
}