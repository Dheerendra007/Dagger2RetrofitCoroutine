package com.dk.dagger2retrofitcoroutines.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dk.dagger2retrofitcoroutines.models.Product
import com.dk.dagger2retrofitcoroutines.repository.ProductRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: ProductRepository,
                                        private val randomize: Randomize): ViewModel(){

     val productsLiveData: LiveData<List<Product>>
        get() = repository.products

      init {
          viewModelScope.launch {
              repository.getProduct()
          }
      }

}

class Randomize @Inject constructor(){
    fun doAction(){
        Log.d("Randomize","doAction")
    }
}