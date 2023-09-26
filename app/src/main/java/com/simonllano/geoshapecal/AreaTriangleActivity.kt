package com.simonllano.geoshapecal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.simonllano.geoshapecal.databinding.ActivityAreaTriangleBinding

class AreaTriangleActivity : AppCompatActivity() {

    private lateinit var areaTriangleBinding: ActivityAreaTriangleBinding
    private lateinit var areaTriangleViewModel: AreaTriangleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        areaTriangleBinding = ActivityAreaTriangleBinding.inflate(layoutInflater)
        val view = areaTriangleBinding.root
        setContentView(view)

        areaTriangleViewModel = ViewModelProvider(this)[AreaTriangleViewModel::class.java]

        val resultAreaTriangleObserver = Observer<Double> {resultArea ->
            areaTriangleBinding.resultAreaTriangleTextView.setText(resultArea.toString())
        }

        areaTriangleViewModel.resultAreaTriangle.observe(this, resultAreaTriangleObserver)

        val errorMsgObserver = Observer<String> { errorMsg ->
            Snackbar.make(view,errorMsg, Snackbar.LENGTH_INDEFINITE)
                .setAction("Aceptar"){ }
                .show()
        }

        areaTriangleViewModel.errorMsg.observe(this,errorMsgObserver)

        areaTriangleBinding.areaTriangleButton.setOnClickListener{
            areaTriangleViewModel.calAreaTriangle(areaTriangleBinding.basisInputEditText.text.toString(), areaTriangleBinding.heightInputEditText.text.toString())

        }

    }
}