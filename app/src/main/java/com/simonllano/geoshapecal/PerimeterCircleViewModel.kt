package com.simonllano.geoshapecal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class PerimeterCircleViewModel : ViewModel(){
    private val perimeter = MutableLiveData<Double?>()

    fun getPerimeter(): LiveData<Double?>? {
        return perimeter
    }

    fun calcularPerimetro(radio: Double) {
        val perimeterValue = if (radio >= 0) {
            2 * Math.PI * radio
        } else {
            null // Manejar radio negativo como necesites
        }
        perimeter.value = perimeterValue
    }

}