package com.pedrohucb.fitech.view.calculadoraimc

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pedrohucb.fitech.R
import com.pedrohucb.fitech.databinding.ActivityCalculadoraImcBinding
import com.pedrohucb.fitech.view.telaprincipal.TelaPrincipal
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class CalculadoraIMC : AppCompatActivity() {

    private lateinit var binding : ActivityCalculadoraImcBinding
    private lateinit var sharedPreferences: SharedPreferences

    private val CHAVEARRAYRESULT = "result_array"
    private val CHAVEARRAYDATE = "date_array"
    private val CONTAINER_FILE = "my_prefs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculadoraImcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences(CONTAINER_FILE, Context.MODE_PRIVATE)
        var arrayResultados = BuscarArraySharedPreferences(CHAVEARRAYRESULT)
        var arrayDatas = BuscarArraySharedPreferences(CHAVEARRAYDATE)

        binding.iconButtonVoltarTelaIMC.setOnClickListener{
            Voltar()
        }

        binding.buttonCalcularIMC.setOnClickListener {

            if(binding.inputPesoIMC.text.toString().isEmpty() || binding.inputAlturaIMC.text.isEmpty()){
                binding.textViewResultadoIMC.text = "Valores invalidos"
                return@setOnClickListener
            }
            val peso = binding.inputPesoIMC.text.toString()
            val altura = binding.inputAlturaIMC.text.toString()



            if(peso.toFloat() <= 0 || altura.toFloat() <= 0){
                binding.textViewResultadoIMC.text = "Valores invalidos"
            }
            else if(peso.toFloat() > 0 && altura.toFloat() > 0){
                val imc = IMC(peso, altura);

                val resultado = String.format("%.2f", imc)
                val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")
                val dataExata = LocalDateTime.now().format(formatter).toString()

                binding.textViewResultadoIMC.text = resultado

                arrayResultados.add(resultado.toString())
                arrayDatas.add(dataExata)

                Salvar(CHAVEARRAYRESULT, arrayResultados)
                Salvar(CHAVEARRAYDATE, arrayDatas)
            }
        }

        binding.buttonCalculosAnteriores.setOnClickListener {
            NavegarHistorico(arrayResultados, arrayDatas);
        }
    }

    private fun NavegarHistorico(arrayResultados : ArrayList<String>, arrayDates : ArrayList<String>){
        val intent = Intent(this, TelaHistoricoDeCalculos::class.java)
        intent.putStringArrayListExtra("array_results", arrayResultados)
        intent.putStringArrayListExtra("array_dates", arrayDates)
        startActivity(intent)
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

    private fun Salvar(key : String, arrayList : ArrayList<String>){
        val editor = sharedPreferences.edit()

        val mySet = arrayList.toSet()

        editor.putStringSet(key ,mySet)

        editor.apply()
    }

    private fun BuscarArraySharedPreferences(key : String) : ArrayList<String>{
        val mySet = sharedPreferences.getStringSet(key, emptySet())

        val myArray = ArrayList<String>()
        myArray.addAll(mySet!!)

        return myArray
    }
}