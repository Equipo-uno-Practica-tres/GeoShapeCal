package com.simonllano.geoshapecal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.simonllano.geoshapecal.databinding.ActivityMainBinding
import com.simonllano.geoshapecal.databinding.ActivitySquareAreaBinding

class SquareAreaActivity : AppCompatActivity() {

    private lateinit var squareAreaBinding: ActivitySquareAreaBinding
    private lateinit var squareAreaMainViewModel: SquareAreaMainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        squareAreaBinding= ActivitySquareAreaBinding.inflate(layoutInflater)
        val view = squareAreaBinding.root
        setContentView(view)
        squareAreaMainViewModel=ViewModelProvider(this)[SquareAreaMainViewModel::class.java]


        val areaobserver = Observer<Double>{area->
            squareAreaBinding.resultadoTextView.setText(area.toString())
        }
        squareAreaMainViewModel.area.observe(this,areaobserver)

        val mensaje5observer = Observer<String>{mensaje5->
            squareAreaBinding.resultadoTextView.setText(mensaje5.toString())

        }
        squareAreaMainViewModel.mensaje5.observe(this,mensaje5observer)


        squareAreaBinding.cuadroAreaaButton.setOnClickListener {

            squareAreaMainViewModel.validateEmpy(squareAreaBinding.sideInputEditText.text.toString())

        }

    }

}