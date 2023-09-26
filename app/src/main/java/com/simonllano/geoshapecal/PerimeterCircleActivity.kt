package com.simonllano.geoshapecal

import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.simonllano.geoshapecal.databinding.ActivityPerimeterCircleBinding


class PerimeterCircleActivity : AppCompatActivity()  {

    private lateinit var perimetercircleBinding: ActivityPerimeterCircleBinding
    private lateinit var perimeterCircleViewModel: PerimeterCircleViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        perimetercircleBinding = ActivityPerimeterCircleBinding.inflate(layoutInflater)
        setContentView(perimetercircleBinding.root)

        perimeterCircleViewModel = ViewModelProvider(this).get(PerimeterCircleViewModel::class.java)

        perimeterCircleViewModel.getPerimeter()?.observe(this, Observer { perimeter ->

            if (perimeter != null) {
                perimetercircleBinding.textViewResult.text = perimeter.toString()
            } else {
                perimetercircleBinding.textViewResult.text = "Por favor, ingrese un radio válido."
            }

        })
        perimetercircleBinding.buttonCalculate.setOnClickListener { calcularPerimetro() }
    }
    private fun calcularPerimetro() {
        val radioTexto = perimetercircleBinding.editTextRadio.text.toString()
        if (radioTexto.isNotEmpty()) {
            val radio = radioTexto.toDoubleOrNull()
            if (radio != null) {
                perimeterCircleViewModel.calcularPerimetro(radio)
            } else {
                perimeterCircleViewModel.calcularPerimetro(-1.0) // Valor no válido, puedes manejarlo según tu necesidad
            }
        } else {
            perimeterCircleViewModel.calcularPerimetro(-1.0) // Valor no válido, puedes manejarlo según tu necesidad
        }
    }
}