package com.dk.dagger2retrofitcoroutines.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    val category: String,
    val description: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)