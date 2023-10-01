package com.dk.dagger2retrofitcoroutines

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dk.dagger2retrofitcoroutines.viewmodels.MainViewModel
import com.dk.dagger2retrofitcoroutines.viewmodels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
 private lateinit var mainViewModel: MainViewModel
 @Inject
 lateinit var mainViewModelFactory: MainViewModelFactory

  val products:TextView
     get() =findViewById(R.id.products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as FakerApplication).applicationComponent.inject(this)
        (application as FakerApplication).applicationComponent.getMap()
        mainViewModel = ViewModelProvider(this,mainViewModelFactory).get(MainViewModel::class.java)
        mainViewModel.productsLiveData.observe(this, Observer {
            products.text = it.joinToString { x->x.title+"\n\n" }
        })
    }
}