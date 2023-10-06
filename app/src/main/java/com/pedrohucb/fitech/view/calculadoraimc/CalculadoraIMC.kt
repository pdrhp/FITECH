package com.pedrohucb.fitech.view.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pedrohucb.fitech.R
import com.pedrohucb.fitech.databinding.ActivityCalculadoraImcBinding
import com.pedrohucb.fitech.view.telaprincipal.TelaPrincipal

class CalculadoraIMC : AppCompatActivity() {

    private lateinit var binding : ActivityCalculadoraImcBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculadoraImcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.iconButtonVoltar.setOnClickListener{
            Voltar()
        }

        binding.buttonCalcularIMC.setOnClickListener {
            val peso = binding.inputPesoIMC.text.toString()
            val altura = binding.inputAlturaIMC.text.toString()

            val imc = IMC(peso, altura);

            val resultado = String.format("%.2f", imc)

            binding.textViewResultadoIMC.text = resultado
        }
    }

    private fun IMC(peso: String, altura: String): Float{

        val pesoFloat = peso.toFloat()
        val alturaFloat = altura.toFloat() / 100

        val resultado = pesoFloat / (alturaFloat * alturaFloat)

        return resultado;
    }

    private fun Voltar(){
        val intent = Intent(this, TelaPrincipal::class.java)
        startActivity(intent)
        finish()
    }
}