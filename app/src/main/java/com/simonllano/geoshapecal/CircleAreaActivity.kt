package com.simonllano.geoshapecal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.simonllano.geoshapecal.databinding.ActivityCircleAreaBinding

class CircleAreaActivity : AppCompatActivity() {

    private lateinit var circleAreaBinding: ActivityCircleAreaBinding
    // Declarar el ViewModel con el de CircleAreaViewModel
    private lateinit var circleAreaViewModel: CircleAreaViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        circleAreaBinding = ActivityCircleAreaBinding.inflate(layoutInflater)
        val view = circleAreaBinding.root
        setContentView(view)
        // inicilizar el viewModel
        circleAreaViewModel = ViewModelProvider(this)[CircleAreaViewModel::class.java]
        // Observador para Area
        val areaObserver = Observer<String> {area->
            circleAreaBinding.resultCircleAreaTextView.setText(area + " m^2")}
        // Poner observador Area
        circleAreaViewModel.area.observe(this, areaObserver)

        val errorMesaggeObserver = Observer<String> {errorMesagge ->
            Toast.makeText(this, errorMesagge, Toast.LENGTH_LONG).show()}
        circleAreaViewModel.errorMessage.observe(this, errorMesaggeObserver)


        // escuchar el Touch del boton circleAreaButtonCalculate
        circleAreaBinding.circleAreaButtonCalculate.setOnClickListener{
            circleAreaViewModel.validateInput(circleAreaBinding.valueCircleAreaEditText.text.toString())

        }
    }
}
