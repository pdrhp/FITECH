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

/**
 * Activity para a Calculadora de IMC.
 */
class CalculadoraIMCActivity : AppCompatActivity() {

    // Instância do objeto de binding com acesso às views do layout.
    private lateinit var binding: ActivityCalculadoraImcBinding
    // ID do produto
    private var produtoId = 0L

    // Inicialização via lazy do objeto DAO do banco de dados Room.
    private val calculosanterioresDao by lazy {
        val db = AppDatabase.instacia(this)
        db.calculosAnterioresDao()
    }


    /**
     * Chamado quando a activity está iniciando.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculadoraImcBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Define o listener de clique para o botão de voltar.
        binding.iconButtonVoltarTelaIMC.setOnClickListener {
            Voltar()
        }

        // Define o listener de clique para o botão de calcular.
        binding.buttonCalcularIMC.setOnClickListener {

            // Verifica se os campos de peso e altura estão vazios.
            if (binding.inputPesoIMC.text.toString()
                    .isEmpty() || binding.inputAlturaIMC.text.isEmpty()
            ) {
                binding.textViewResultadoIMC.text = "Valores invalidos"
                return@setOnClickListener
            }
            val peso = binding.inputPesoIMC.text.toString()
            val altura = binding.inputAlturaIMC.text.toString()

            // Verifica se o peso e a altura são válidos.
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
        // Define o listener de clique para o botão de histórico.
        binding.buttonCalculosAnteriores.setOnClickListener {
            NavegarHistorico();
        }
    }

    /**
     * Salva o cálculo no histórico.
     */
    private fun salvaCalculoNoHistorico(novoCalculoAnterior: CalculoAnteriores) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                calculosanterioresDao.salva(novoCalculoAnterior)
            }
        }
    }

    /**
     * Navega para a tela de histórico.
     */
    private fun NavegarHistorico() {
        val intent = Intent(this, TelaHistoricoDeCalculosActivity::class.java)
        startActivity(intent)
    }

    /**
     * Calcula o IMC.
     */
    private fun IMC(peso: String, altura: String): Float {
        val pesoFloat = peso.toFloat()
        val alturaFloat = altura.toFloat() / 100

        val resultado = pesoFloat / (alturaFloat * alturaFloat)

        return resultado;
    }

    /**
     * Volta para a tela Principal
     */
    private fun Voltar() {
        val intent = Intent(this, TelaPrincipalActivity::class.java)
        startActivity(intent)
        finish()
    }

    /**
     * Cria um novo objeto do tipo CalculoAnteriores.
     */
    private fun criaCalculosAnteriores(resultado: String, data: String): CalculoAnteriores {
        return CalculoAnteriores(
            id = produtoId,
            resultadoCalculo = resultado,
            dataCalculo = data
        )
    }
}