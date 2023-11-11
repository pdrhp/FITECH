package com.pedrohucb.fitech.ui.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.pedrohucb.fitech.database.AppDatabase
import com.pedrohucb.fitech.databinding.ActivityTelaHistoricoDeCalculosBinding
import com.pedrohucb.fitech.models.CalculoAnteriores
import com.pedrohucb.fitech.ui.adapters.AdapterCalculoAnteriores
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TelaHistoricoDeCalculosActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTelaHistoricoDeCalculosBinding
    private val calculosAnterioresDao by lazy {
        AppDatabase.instacia(this).calculosAnterioresDao()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaHistoricoDeCalculosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.iconButtonVoltarHistorico.setOnClickListener{
            Voltar()
        }

        lifecycleScope.launch{
            var list : List<CalculoAnteriores> = withContext(Dispatchers.IO){
                calculosAnterioresDao.buscaTodos()
            }

            withContext(Dispatchers.Main){
                binding.listaHistoricoDeResultados.adapter = AdapterCalculoAnteriores(this@TelaHistoricoDeCalculosActivity, list)
            }
        }

    }

    private fun Voltar(){
        val intent = Intent(this, CalculadoraIMCActivity::class.java)
        startActivity(intent)
        finish()
    }
}