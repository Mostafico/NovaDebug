package com.example.novadebug.model.clinic.reservation

import com.example.novadebug.model.clinic.Doctor

data class Reservation(
    val id: String = "",
    val area: ArrayList<String> = ArrayList(),
    val branch: String = "",
    val device: String = "",
    val doctor: Doctor,
    val status: String = "",
    val time: Long,
    val userId: String = "",
)

