package com.pedrohucb.fitech.ui.activitys

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pedrohucb.fitech.databinding.ActivityListExerciciosSubListBinding
import com.pedrohucb.fitech.models.ExercicioRepositoryAbdominais
import com.pedrohucb.fitech.models.ExercicioRepositoryInferiores
import com.pedrohucb.fitech.models.ExercicioRepositorySuperiores
import com.pedrohucb.fitech.ui.adapters.AdapterExercicio

/**
 * Activity para a lista de exercícios.
 */
class ListExerciciosSubListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityListExerciciosSubListBinding

    // Instância do objeto de binding com acesso às views do layout.

    /**
     * Chamado quando a activity está iniciando.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListExerciciosSubListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val regiao = intent.getIntExtra("position", 3)
        escolheRegiaoExercicio(regiao)

        // Define o listener de clique para os itens da lista de exercícios.
        binding.listViewListaDeExercicios.setOnItemClickListener { parent, view, position, id ->
            DetalharExercicio(regiao, position)
        }

        // Define o listener de clique para o botão de voltar.
        binding.iconButtonVoltarTelaListaExercicios.setOnClickListener {
            VoltarTelaAnterior()
        }
    }

    /**
     * Escolhe a região do exercício.
     */
    private fun escolheRegiaoExercicio(regiao: Int) {
        if (regiao == 0) {
            binding.listViewListaDeExercicios.adapter =
                AdapterExercicio(this, ExercicioRepositorySuperiores.getExercicios())
        } else if (regiao == 1) {
            binding.listViewListaDeExercicios.adapter =
                AdapterExercicio(this, ExercicioRepositoryInferiores.getExercicios())
        } else if (regiao == 2) {
            binding.listViewListaDeExercicios.adapter =
                AdapterExercicio(this, ExercicioRepositoryAbdominais.getExercicios())
        }
    }

    /**
     * Retorna para a tela anterior.
     */
    private fun VoltarTelaAnterior(){
        val intent = Intent(this, ListExerciciosActivity::class.java)
        startActivity(intent)
        finish()
    }

    /**
     * Detalha o exercício.
     */
    private fun DetalharExercicio(regiao:Int, position : Int){
        val intent = Intent(this, ExercicioDetailedActivity::class.java)
        intent.putExtra("regiao", regiao)
        intent.putExtra("position", position)
        startActivity(intent)
    }
}
