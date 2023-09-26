package com.simonllano.geoshapecal

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData


class PerimeterSquareViewModel: ViewModel() {


    val resultado: MutableLiveData<Double> by lazy{ //Live data
        MutableLiveData<Double>()
    }

    private val  _errorMsg: MutableLiveData<String> = MutableLiveData()
    val errorMsg: LiveData<String> = _errorMsg
    fun perimetroCuadro(side: String) {

        if(side.isEmpty()) {
            _errorMsg.value = "Debe digitar un valor"}

        else{
            resultado.value= 4*(side.toDouble())
            }

    }
}





