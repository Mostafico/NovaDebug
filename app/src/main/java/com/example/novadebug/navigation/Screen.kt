package com.example.novadebug.navigation

import com.example.novadebug.util.RESERVATIONS_SCREEN_ROUTE

sealed class Screen(val route: String){
    object Reservations: Screen(route = RESERVATIONS_SCREEN_ROUTE)
}
