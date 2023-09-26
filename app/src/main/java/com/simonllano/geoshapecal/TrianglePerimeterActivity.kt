package com.simonllano.geoshapecal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.simonllano.geoshapecal.databinding.ActivityTrianglePerimeterBinding

class TrianglePerimeterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTrianglePerimeterBinding
    private lateinit var viewModel: TriangleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrianglePerimeterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[TriangleViewModel::class.java]

        binding.trianglePeriButton.setOnClickListener {
            val sideLength = binding.valorInputEditText.text.toString().toDoubleOrNull()
            sideLength?.let { viewModel.calculatePerimeter(it) }
        }

        val perimeterObserver = Observer<Double> { perimeter ->
            binding.resultadoTextView.text = perimeter.toString()
        }

        viewModel.perimeter.observe(this, perimeterObserver)

    }
}
