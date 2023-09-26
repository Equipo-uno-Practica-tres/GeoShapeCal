package com.simonllano.geoshapecal

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CircleAreaViewModel:ViewModel() {

    // crear LiveData
    val area: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val errorMessage: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }


    fun validateInput(inputArea: String) {
        if(inputArea.isEmpty()) {
            errorMessage.value = "Ingrese un numero para calcular area"
        }
        else {
            var areaOne = (inputArea.toDouble() * inputArea.toDouble() * 3.1416).toString()
            areaOne = String.format("%.2f", areaOne.toDouble())
            area.value = areaOne
        }

    }


}