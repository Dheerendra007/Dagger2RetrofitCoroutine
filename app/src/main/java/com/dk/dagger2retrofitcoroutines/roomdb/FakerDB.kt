package com.dk.dagger2retrofitcoroutines.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dk.dagger2retrofitcoroutines.models.Product

@Database(entities = [Product::class], version = 1)
abstract class FakerDB: RoomDatabase() {

    abstract fun getFakerDAO():FakerDao
}