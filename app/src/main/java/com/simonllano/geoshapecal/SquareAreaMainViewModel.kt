package com.simonllano.geoshapecal

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.pow

class SquareAreaMainViewModel: ViewModel()  {


    val area: MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }
    val mensaje5: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun validateEmpy(number1: String) {
        if (number1.isEmpty() ){
            mensaje5.value = "debe digitar un numero"

        }else {

            val lado = number1.toDouble()

            area.value = lado*lado


        }


    }

}