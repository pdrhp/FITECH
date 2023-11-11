package com.pedrohucb.fitech.ui.activitys

import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.pedrohucb.fitech.R
import com.pedrohucb.fitech.databinding.ActivityCalculadoratmbBinding
import com.pedrohucb.fitech.models.DailyCaloriesRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

class CalculadoraTMBActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculadoratmbBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculadoratmbBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val genderItems = arrayOf("Masculino", "Feminino")
        val spinnerGenderAdapter = ArrayAdapter(this, R.layout.spinner_dropdown_item, genderItems)

        val atvFisItems = arrayOf(
            "Sedentario",
            "Exercicito 1-3 semanalmente",
            "Exercito 4-5 Semanalmente",
            "Exercito Diaramente",
            "Exercito Intensamente todos os dias"
        )
        val spinnerAtvFisAdapter = ArrayAdapter(this, R.layout.spinner_dropdown_item, atvFisItems)

        val apiKey = recuperaAPIKEY()

        binding.inputGeneroTBM.adapter = spinnerGenderAdapter
        binding.inputNvAtvFisTBM.adapter = spinnerAtvFisAdapter

        binding.iconButtonVoltarTelaTMB.setOnClickListener { VoltarTela() }

        binding.buttonCalcularTBM.setOnClickListener {
            configuraBotaoCalcular(apiKey)
        }
    }

    private fun configuraBotaoCalcular(apiKey: String) {
        if (binding.inputIdadeTBM.text.toString()
                .isEmpty() || binding.inputPesoTBM.text.toString()
                .isEmpty() || binding.inputAlturaTBM.text.toString().isEmpty()
        ) {
            binding.textViewResultadoTMB.text = "Informações invalidas"
            return
        }
        val idade = binding.inputIdadeTBM.text.toString()
        val peso = binding.inputPesoTBM.text.toString()
        val altura = binding.inputAlturaTBM.text.toString()
        val genero = HomemOuMulher(binding.inputGeneroTBM.selectedItem.toString())
        val nvatvfis = NvAtvOptionSelector(binding.inputNvAtvFisTBM.selectedItem.toString())

        CoroutineScope(Dispatchers.IO).launch {
            val result = getCaloriasDiarias(idade, genero, altura, peso, nvatvfis, apiKey)

            withContext(Dispatchers.Main) {
                if (result.data.BMR.isNotEmpty()) {
                    binding.textViewResultadoTMB.text = "${result.data.BMR} Calorias por dia"
                } else {
                    binding.textViewResultadoTMB.text = "Resultado não encontrado"
                }
            }
        }
    }

    private fun recuperaAPIKEY(): String {
        val applicationInfo: ApplicationInfo = application.packageManager.getApplicationInfo(
            application.packageName,
            PackageManager.GET_META_DATA
        )
        val apiKey = applicationInfo.metaData["API_KEY"].toString()
        return apiKey
    }

    private fun VoltarTela() {
        val intent = Intent(this, TelaPrincipalActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun getCaloriasDiarias(
        idade: String,
        genero: String,
        altura: String,
        peso: String,
        nvAtvFis: String,
        apikey: String
    ): DailyCaloriesRequest {
        val client = OkHttpClient();

        val request = Request.Builder()
            .url("https://fitness-calculator.p.rapidapi.com/dailycalorie?age=${idade}&gender=${genero}&height=${altura}&weight=${peso}&activitylevel=${nvAtvFis}")
            .get()
            .addHeader("X-RapidAPI-Key", apikey)
            .addHeader("X-RapidAPI-Host", "fitness-calculator.p.rapidapi.com")
            .build()

        val response = client.newCall(request).execute();

        val responseString = response.body!!.string()

        val bmr = Gson().fromJson(responseString, DailyCaloriesRequest::class.java)

        return bmr;
    }

    private fun HomemOuMulher(genero: String): String {
        if (genero == "Masculino") {
            return "male"
        } else {
            return "female"
        }
    }

    private fun NvAtvOptionSelector(nivel: String): String {
        if (nivel == "Sedentario") {
            return "level_1"
        } else if (nivel == "Exercicito 1-3 semanalmente") {
            return "level_2"
        } else if (nivel == "Exercito 4-5 Semanalmente") {
            return "level_3"
        } else if (nivel == "Exercito Diaramente") {
            return "level_4"
        } else if (nivel == "Exercito Intensamente todos os dias") {
            return "level_5"
        }
        return "Valor não encontrado"
    }
}