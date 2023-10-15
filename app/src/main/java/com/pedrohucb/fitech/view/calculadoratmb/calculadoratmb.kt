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
        val atvFisItems = arrayOf("Sedentario", "Exercicito 1-3 semanalmente", "Exercito 4-5 Semanalmente", "Exercito Diaramente", "Exercito Intensamente todos os dias")

        val spinnerGenderAdapter = ArrayAdapter(this, R.layout.spinner_dropdown_item, genderItems)
        val spinnerAtvFisAdapter = ArrayAdapter(this, R.layout.spinner_dropdown_item, atvFisItems)



        binding.inputGeneroTBM.adapter = spinnerGenderAdapter
        binding.inputNvAtvFisTBM.adapter = spinnerAtvFisAdapter

        binding.buttonCalcularTBM.setOnClickListener {
            val idade = binding.inputIdadeTBM.text.toString()
            val genero = HomemOuMulher(binding.inputGeneroTBM.selectedItem.toString())
            val peso = binding.inputPesoTBM.text.toString()
            val altura = binding.inputAlturaTBM.text.toString()
            val nvatvfis = NvAtvOptionSelector(binding.inputNvAtvFisTBM.selectedItem.toString())

        }
    }




    fun HomemOuMulher(genero: String): String{
        if (genero == "Masculino"){
            return "male"
        }else{
            return "female"
        }
    }

    fun NvAtvOptionSelector(nivel : String): String{
        if (nivel == "Sedentario"){
            return "level_1"
        }
        else if(nivel == "Exercicito 1-3 semanalmente"){
            return "level_2"
        }
        else if(nivel == "Exercito 4-5 Semanalmente"){
            return "level_3"
        }
        else if(nivel == "Exercito Diaramente"){
            return "level_4"
        }
        else if(nivel == "Exercito Intensamente todos os dias"){
            return "level_5"
        }
        return "Valor não encontrado"
    }
}