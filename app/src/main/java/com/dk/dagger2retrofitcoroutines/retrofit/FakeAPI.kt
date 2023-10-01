package com.dk.dagger2retrofitcoroutines.retrofit

import com.dk.dagger2retrofitcoroutines.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakeAPI {

    @GET("products")
    suspend fun getProduct(): Response<List<Product>>
}