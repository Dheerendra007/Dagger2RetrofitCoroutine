package com.dk.dagger2retrofitcoroutines.di

import androidx.lifecycle.ViewModel
import androidx.room.MapInfo
import com.dk.dagger2retrofitcoroutines.viewmodels.MainViewModel
import com.dk.dagger2retrofitcoroutines.viewmodels.MainViewModel2
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @ClassKey(MainViewModel::class)
    @IntoMap
    abstract fun mainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @ClassKey(MainViewModel2::class)
    @IntoMap
    abstract fun mainViewModel2(mainViewModel2: MainViewModel2): ViewModel
}