package com.example.novadebug.di

import com.example.novadebug.common.CLIENTS_COLLECTION
import com.example.novadebug.common.CLIENT_NAME
import com.example.novadebug.common.CLIENT_RESERVATIONS
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideFirebaseFirestore() = Firebase.firestore

    @Provides
    fun provideReservationsRef(
        db: FirebaseFirestore,
    ) = db.collection(CLIENTS_COLLECTION).document(CLIENT_NAME).collection(CLIENT_RESERVATIONS)
}