package com.example.novadebug.model.clinic

import com.example.novadebug.model.clinic.reservation.Reservation

data class Client(
    var name: String = "",
    var doctors: MutableList<Doctor> = mutableListOf(),
    var users: MutableList<User> = mutableListOf(),
    var reservations: MutableList<Reservation> = mutableListOf()
)
