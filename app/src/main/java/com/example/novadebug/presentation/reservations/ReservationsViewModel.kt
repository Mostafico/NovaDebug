package com.example.novadebug.presentation.reservations


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.novadebug.domain.model.Response.*
import com.example.novadebug.domain.repository.ReservationsResponse
import com.example.novadebug.domain.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue


private const val TAG = "ReservationsViewModel"

@HiltViewModel
class ReservationsViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel() {
    var reservationsResponse by mutableStateOf<ReservationsResponse>(Loading)
        private set


    init {
        getReservations()
    }

    private fun getReservations() = viewModelScope.launch {
        useCases.getReservations().collect { response ->
            reservationsResponse = response
        }
    }


//
//    fun addNewReservation(reservation: Reservation) {
//        viewModelScope.launch {
//            reservationRef.add(reservation)
//                .addOnSuccessListener {
//                    Log.d(TAG, "Added Document Successfully with ID : ${it.id}")
//                }
//                .addOnFailureListener {
//                    Log.e(TAG, "Failed to Add Document", it.cause)
//                }
//        }
//    }
}