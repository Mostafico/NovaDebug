package com.example.novadebug.data.repository

import com.example.novadebug.domain.repository.ClinicRepository
import com.example.novadebug.domain.repository.ReservationsResponse
import kotlinx.coroutines.flow.Flow

class ClinicRepositoryImpl : ClinicRepository {
    override fun getReservations(): Flow<ReservationsResponse> {
        TODO("Not yet implemented")
    }
}