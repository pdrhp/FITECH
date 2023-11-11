package com.pedrohucb.fitech.ui.activitys

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.pedrohucb.fitech.database.AppDatabase
import com.pedrohucb.fitech.databinding.ActivityCalculadoraImcBinding
import com.pedrohucb.fitech.models.CalculoAnteriores
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class CalculadoraIMCActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculadoraImcBinding
    private var produtoId = 0L

    private val calculosanterioresDao by lazy {
        val db = AppDatabase.instacia(this)
        db.calculosAnterioresDao()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculadoraImcBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.iconButtonVoltarTelaIMC.setOnClickListener {
            Voltar()
        }

        binding.buttonCalcularIMC.setOnClickListener {

            if (binding.inputPesoIMC.text.toString()
                    .isEmpty() || binding.inputAlturaIMC.text.isEmpty()
            ) {
                binding.textViewResultadoIMC.text = "Valores invalidos"
                return@setOnClickListener
            }
            val peso = binding.inputPesoIMC.text.toString()
            val altura = binding.inputAlturaIMC.text.toString()


            if (peso.toFloat() <= 0 || altura.toFloat() <= 0) {
                binding.textViewResultadoIMC.text = "Valores invalidos"
            } else if (peso.toFloat() > 0 && altura.toFloat() > 0) {
                val imc = IMC(peso, altura);

                val resultado = String.format("%.2f", imc)
                val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")
                val dataExata = LocalDateTime.now().format(formatter).toString()

                binding.textViewResultadoIMC.text = resultado

                val novoCalculoAnterior = criaCalculosAnteriores(resultado, dataExata)
                salvaCalculoNoHistorico(novoCalculoAnterior)

            }
        }

        binding.buttonCalculosAnteriores.setOnClickListener {
            NavegarHistorico();
        }
    }

    private fun salvaCalculoNoHistorico(novoCalculoAnterior: CalculoAnteriores) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                calculosanterioresDao.salva(novoCalculoAnterior)
            }
        }
    }

    private fun NavegarHistorico() {
        val intent = Intent(this, TelaHistoricoDeCalculosActivity::class.java)
        startActivity(intent)
    }

    private fun IMC(peso: String, altura: String): Float {
        val pesoFloat = peso.toFloat()
        val alturaFloat = altura.toFloat() / 100

        val resultado = pesoFloat / (alturaFloat * alturaFloat)

        return resultado;
    }

    private fun Voltar() {
        val intent = Intent(this, TelaPrincipalActivity::class.java)
        startActivity(intent)
        finish()
    }


    private fun criaCalculosAnteriores(resultado: String, data: String): CalculoAnteriores {
        return CalculoAnteriores(
            id = produtoId,
            resultadoCalculo = resultado,
            dataCalculo = data
        )
    }
}