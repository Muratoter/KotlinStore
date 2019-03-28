package com.moter.firestore.db.firestore

import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.moter.firestore.entity.Task


class DatabaseRepo(var firestore: FirebaseFirestore) {
    fun getAllTask(liveDataTasks: MutableLiveData<List<Task>>) {

        References.TaskReference(firestore).addSnapshotListener { querySnapshot, firebaseFirestoreException ->
            val tasks = mutableListOf<Task>()
            for (document in querySnapshot!!.documents){
                val task = document.toObject(Task::class.java)
                task?.id = document.id
                tasks.add(task!!)
            }
            liveDataTasks.value = tasks

        }

    }
}