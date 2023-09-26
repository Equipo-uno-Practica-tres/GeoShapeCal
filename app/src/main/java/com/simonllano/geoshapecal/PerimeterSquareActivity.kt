package com.simonllano.geoshapecal
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.simonllano.geoshapecal.databinding.ActivityPerimeterSquareBinding


class PerimeterSquareActivity : AppCompatActivity() {
    private lateinit var perimeterSquareBinding: ActivityPerimeterSquareBinding
    private lateinit var perimeterSquareViewModel: PerimeterSquareViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        perimeterSquareBinding = ActivityPerimeterSquareBinding.inflate(layoutInflater)
        perimeterSquareViewModel = ViewModelProvider(this)[PerimeterSquareViewModel::class.java] //inicializando ViewModel
        super.onCreate(savedInstanceState)
        val view = perimeterSquareBinding.root
        setContentView(view)

        perimeterSquareBinding.cuadroPerimetButton.setOnClickListener {
            perimeterSquareViewModel.perimetroCuadro(perimeterSquareBinding.sideInputEditText.text.toString())

        }
        val resultadoObserver = Observer<Double> {resultado->  //Se crea el objeto observer
            perimeterSquareBinding.resultTextView.setText(resultado.toString())
        }
        perimeterSquareViewModel.resultado.observe(this, resultadoObserver) //Se conecta el view model con ...


        val errorMsgObserver = Observer<String> {errorMsg ->
            Snackbar.make(view, errorMsg, Snackbar.LENGTH_INDEFINITE)
                .setAction( "Aceptar") {}
                .show()
        }
        perimeterSquareViewModel.errorMsg.observe(this, errorMsgObserver)

    }
}


