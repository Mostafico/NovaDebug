package com.example.novadebug.domain.use_case

import com.example.novadebug.domain.model.clinic.Reservation
import com.example.novadebug.domain.repository.ClinicRepository

class AddReservation(private val repo: ClinicRepository) {
    suspend operator fun invoke(reservation: Reservation) = repo.addReservation(reservation)
}