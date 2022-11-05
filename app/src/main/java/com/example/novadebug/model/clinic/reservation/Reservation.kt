package com.example.novadebug.model.clinic.reservation

import com.example.novadebug.model.clinic.Doctor
import com.google.firebase.Timestamp
import com.google.firebase.firestore.ServerTimestamp
import kotlin.collections.ArrayList


data class Reservation(
    val id: String = "",
    val area: ArrayList<String> = ArrayList(),
    val branch: String = "",
    val device: String = "",
    val doctor: Doctor = Doctor(),
    val status: String = "",
    @ServerTimestamp val dateTime: Timestamp = Timestamp.now(),
    val userId: String = "",
    val expectedDurationMin: Int = 0,
)

