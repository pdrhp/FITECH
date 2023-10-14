package com.pedrohucb.fitech.view.calculadoratmb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.pedrohucb.fitech.R
import com.pedrohucb.fitech.databinding.ActivityCalculadoratmbBinding

class calculadoratmb : AppCompatActivity() {

    private lateinit var binding : ActivityCalculadoratmbBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculadoratmbBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val genderItems = arrayOf("Masculino", "Feminino")
        val atvFisItems = arrayOf("Sedentario", "Exercicito 1-3 semanalmente", "Exercito 4-5 Semanalmente", "Exercito Diaramente", "Exercito Intensamente")

        val spinnerGenderAdapter = ArrayAdapter(this, R.layout.spinner_dropdown_item, genderItems)
        val spinnerAtvFisAdapter = ArrayAdapter(this, R.layout.spinner_dropdown_item, atvFisItems)

        binding.inputGeneroTBM.adapter = spinnerGenderAdapter
        binding.inputNvAtvFisTBM.adapter = spinnerAtvFisAdapter
    }
}