package com.simonllano.geoshapecal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TriangleViewModel : ViewModel() {

    private val _perimeter = MutableLiveData<Double>()
    val perimeter: LiveData<Double> get() = _perimeter

    private val _errorMsg = MutableLiveData<String>()
    val errorMsg: LiveData<String> get() = _errorMsg

    fun calculatePerimeter(sideLength: Double) {
        if (sideLength > 0) {
            val perimeterValue = sideLength * 3
            _perimeter.value = perimeterValue
        } else {
            _errorMsg.value = "El lado debe ser mayor que cero"
        }
    }
}
