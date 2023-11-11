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

/**
 * Activity para a tela "Histórico de Cálculos".
 */
class TelaHistoricoDeCalculosActivity : AppCompatActivity() {

    // Instância do objeto de binding com acesso às views do layout.
    private lateinit var binding : ActivityTelaHistoricoDeCalculosBinding
    // Inicialização preguiçosa do objeto DAO do banco de dados Room.
    private val calculosAnterioresDao by lazy {
        AppDatabase.instacia(this).calculosAnterioresDao()
    }

    /**
     * Chamado quando a activity está iniciando.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaHistoricoDeCalculosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Define o listener de clique para o botão de voltar.
        binding.iconButtonVoltarHistorico.setOnClickListener{
            Voltar()
        }

        // Inicia uma coroutine para buscar todos os cálculos anteriores no banco de dados.
        lifecycleScope.launch{
            var list : List<CalculoAnteriores> = withContext(Dispatchers.IO){
                calculosAnterioresDao.buscaTodos()
            }

            // Atualiza a lista de cálculos anteriores na thread principal.
            withContext(Dispatchers.Main){
                binding.listaHistoricoDeResultados.adapter = AdapterCalculoAnteriores(this@TelaHistoricoDeCalculosActivity, list)
            }
        }

    }

    /**
     * Retorna para a tela de cálculo de IMC.
     */
    private fun Voltar(){
        val intent = Intent(this, CalculadoraIMCActivity::class.java)
        startActivity(intent)
        finish()
    }
}