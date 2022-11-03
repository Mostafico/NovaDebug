package com.example.novadebug.model.clinic.reservation

data class Reservation(
    val reservationID: String,
    val branch: ClinicBranch,
    val device: ClinicDevice
)
