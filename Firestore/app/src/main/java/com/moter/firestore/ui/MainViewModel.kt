package com.moter.firestore.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.moter.firestore.db.firestore.DatabaseRepo
import com.moter.firestore.entity.Task


class MainViewModel(databaseRepo: DatabaseRepo) : ViewModel() {

    var liveDataTasks = MutableLiveData<List<Task>>()

    init {
        databaseRepo.getAllTask(liveDataTasks)
    }
}