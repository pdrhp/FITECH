package com.pedrohucb.fitech.view.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pedrohucb.fitech.R
import com.pedrohucb.fitech.databinding.ActivityTelaHistoricoDeCalculosBinding

class TelaHistoricoDeCalculos : AppCompatActivity() {

    private lateinit var binding : ActivityTelaHistoricoDeCalculosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaHistoricoDeCalculosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.iconButtonVoltarHistorico.setOnClickListener{
            Voltar()
        }

        val resultadoCalculo = intent.getStringArrayListExtra("array_results")
        val dataCalculo = intent.getStringArrayListExtra("array_dates")

        var list : List<CalculoAnteriores> = resultadoCalculo!!.zip(dataCalculo!!.toList(), ::CalculoAnteriores)

        binding.listaHistoricoDeResultados.adapter = AdapterCalculoAnteriores(this, list)
    }

    private fun Voltar(){
        val intent = Intent(this, CalculadoraIMC::class.java)
        startActivity(intent)
        finish()
    }
}