package com.example.novadebug.model.clinic.reservation

import com.example.novadebug.model.clinic.Doctor
import com.google.firebase.Timestamp

data class Reservation(
    val id: String = "",
    val area: ArrayList<String> = ArrayList(),
    val branch: String = "",
    val device: String = "",
    val doctor: Doctor = Doctor(),
    val status: String = "",
    val time: Timestamp = Timestamp.now(),
    val userId: String = "",
    val expectedDuration: Int = 0,
)

