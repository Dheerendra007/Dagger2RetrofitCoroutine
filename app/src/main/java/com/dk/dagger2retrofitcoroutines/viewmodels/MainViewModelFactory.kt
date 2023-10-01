package com.dk.dagger2retrofitcoroutines.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dk.dagger2retrofitcoroutines.repository.ProductRepository
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val map: Map<Class<*>,@JvmSuppressWildcards ViewModel>)
    :ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return map[modelClass] as T
    }
}