package com.example.novadebug.domain.use_case

import com.example.novadebug.domain.repository.ClinicRepository

class GetReservations(private val repo: ClinicRepository) {
    operator fun invoke() = repo.getReservations()
}