package com.moter.firestore.db.firestore

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore


object References {
    private val task: String = "task"

    fun TaskReference(firestore: FirebaseFirestore):CollectionReference{
        return firestore.collection(task)
    }
}
