package com.dk.dagger2retrofitcoroutines

import android.app.Application
import com.dk.dagger2retrofitcoroutines.di.ApplicationComponent
import com.dk.dagger2retrofitcoroutines.di.DaggerApplicationComponent

class FakerApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}