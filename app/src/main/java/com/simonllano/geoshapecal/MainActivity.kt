package com.simonllano.geoshapecal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.simonllano.geoshapecal.databinding.ActivityMainBinding


import com.simonllano.geoshapecal.databinding.ActivityPerimeterSquareBinding
//Prueba
class MainActivity : AppCompatActivity() {

    private lateinit var geoshapecalBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Base_Theme_GeoShapeCal)
        super.onCreate(savedInstanceState)
        geoshapecalBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = geoshapecalBinding.root
        setContentView(view)


        geoshapecalBinding.cuadroPerimeterButton.setOnClickListener {//Aca se envia la orden para abrir la actividad
            val intent = Intent(
                this,
                PerimeterSquareActivity::class.java
            ) //donde se encontrara el perimetro del cuadrado
            startActivity(intent)
        }
        geoshapecalBinding.circlePerimeterButton.setOnClickListener {//Aca se envia la orden para abrir la actividad
            val intent = Intent(
                this,
                PerimeterCircleActivity::class.java
            ) //donde se encontrara el perimetro del cuadrado
            startActivity(intent)
        }
        geoshapecalBinding.triangleAreaButton.setOnClickListener {
            val intent = Intent(this, AreaTriangleActivity::class.java)
            startActivity(intent)
        }

        geoshapecalBinding.trianglePerimeterButton.setOnClickListener {//Aca se envia la orden para abrir la actividad
            val intent = Intent(this,TrianglePerimeterActivity::class.java) //donde se encontrara el perimetro del cuadrado
            startActivity(intent)
        }



           // mainViewModel.resultado.observe(this, resultadoObserver) //Se conecta el view model con el observer
        geoshapecalBinding.cuadroAreaButton.setOnClickListener {
            val intent =Intent(this,SquareAreaActivity::class.java)
            startActivity(intent)

        }
        geoshapecalBinding.circleAreaButton.setOnClickListener {
            val intent = Intent(this,CircleAreaActivity::class.java)
            startActivity(intent)
        }

    }
}
