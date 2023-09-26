package com.simonllano.geoshapecal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AreaTriangleViewModel: ViewModel() {

    val resultAreaTriangle: MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }

    private val _errorMsg: MutableLiveData<String> = MutableLiveData()
    val errorMsg: LiveData<String> = _errorMsg


    fun calAreaTriangle(basis: String, height: String) {
        if(basis.isEmpty() || height.isEmpty()){
            _errorMsg.value = "Debe digitar ambos campos"
        }else{
            resultAreaTriangle.value = (basis.toDouble() * height.toDouble()) / 2
        }
    }


}