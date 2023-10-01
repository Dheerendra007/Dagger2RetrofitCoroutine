package com.dk.dagger2retrofitcoroutines.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dk.dagger2retrofitcoroutines.models.Product

@Dao
interface FakerDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(products:List<Product>)

    @Query("SELECT * FROM Product")
    fun getProducts(): List<Product>
}