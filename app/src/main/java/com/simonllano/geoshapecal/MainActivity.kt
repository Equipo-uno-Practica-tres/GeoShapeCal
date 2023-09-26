package com.simonllano.geoshapecal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.simonllano.geoshapecal.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var geoshapecalBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        geoshapecalBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = geoshapecalBinding.root
        setContentView(view)


        geoshapecalBinding.cuadroPerimeterButton.setOnClickListener {//Aca se envia la orden para abrir la actividad
                    val intent = Intent(this,PerimeterSquareActivity::class.java) //donde se encontrara el perimetro del cuadrado
                    startActivity(intent)
        }

    }

}
