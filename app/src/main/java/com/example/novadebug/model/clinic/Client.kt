package com.example.novadebug.model.clinic

import com.example.novadebug.model.clinic.reservation.Reservation

data class Client(
    var clientName: String,
    var clientDoctors: MutableList<Doctor>,
    var clientUsers: MutableList<User>,
    var reservations: MutableList<Reservation>
)
