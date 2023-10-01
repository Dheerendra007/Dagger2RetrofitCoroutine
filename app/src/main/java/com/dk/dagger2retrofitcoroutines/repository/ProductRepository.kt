package com.dk.dagger2retrofitcoroutines.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dk.dagger2retrofitcoroutines.models.Product
import com.dk.dagger2retrofitcoroutines.retrofit.FakeAPI
import com.dk.dagger2retrofitcoroutines.roomdb.FakerDB
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakeAPI: FakeAPI, private val fakerDB: FakerDB){

    private val _products = MutableLiveData<List<Product>>()
    val products:LiveData<List<Product>> get() =_products

    suspend fun getProduct(){
        val result = fakeAPI.getProduct()
        if(result.isSuccessful && result.body()!=null){
             fakerDB.getFakerDAO().addProducts(result.body()!!)
            _products.postValue(result.body())
        }
    }
}