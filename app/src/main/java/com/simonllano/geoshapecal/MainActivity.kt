package com.simonllano.geoshapecal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.simonllano.geoshapecal.databinding.ActivityMainBinding
import com.simonllano.geoshapecal.databinding.ActivityPerimeterSquareBinding

class MainActivity : AppCompatActivity() {

    private lateinit var geoshapecalBinding: ActivityMainBinding

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        geoshapecalBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = geoshapecalBinding.root
        setContentView(view)

        mainViewModel= ViewModelProvider(this)[MainViewModel::class.java]

        geoshapecalBinding.triangleAreaButton.setOnClickListener {
            val intent = Intent(this, AreaTriangleActivity::class.java)
            startActivity(intent)
        }

        //val resultadoObserver = Observer<String> {resultado->  //Se crea el objeto observer
          //  perimeterSquareBinding.resultTextView.setText(resultado.toString())} //muestra el resultado del perimetro

           // mainViewModel.resultado.observe(this, resultadoObserver) //Se conecta el view model con el observer
    }

}
