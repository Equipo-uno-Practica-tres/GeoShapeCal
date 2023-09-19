package com.simonllano.geoshapecal

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel //Libreria del view model

class MainViewModel: ViewModel() { //herencia del viewmdodel

    val resultado: MutableLiveData<String> by lazy{ //Live data
        MutableLiveData<String>()
    }

}