package com.moter.firestore.entity

import android.os.Parcelable
import com.google.firebase.Timestamp
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize
import java.util.*


@Parcelize
data class Task(var id: String = "", var name: String, var schedule: Timestamp) : Parcelable {
    constructor() : this("", "", Timestamp.now())
}