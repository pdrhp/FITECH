package com.pedrohucb.fitech.ui.activitys

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pedrohucb.fitech.databinding.ActivityListExerciciosSubListBinding
import com.pedrohucb.fitech.models.ExercicioRepositoryAbdominais
import com.pedrohucb.fitech.models.ExercicioRepositoryInferiores
import com.pedrohucb.fitech.models.ExercicioRepositorySuperiores
import com.pedrohucb.fitech.ui.adapters.AdapterExercicio

class ListExerciciosSubListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityListExerciciosSubListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListExerciciosSubListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val regiao = intent.getIntExtra("position", 3)
        escolheRegiaoExercicio(regiao)
        
        binding.listViewListaDeExercicios.setOnItemClickListener { parent, view, position, id ->
            DetalharExercicio(regiao, position)
        }


        binding.iconButtonVoltarTelaListaExercicios.setOnClickListener {
            VoltarTelaAnterior()
        }
    }

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

    private fun VoltarTelaAnterior(){
        val intent = Intent(this, ListExerciciosActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun DetalharExercicio(regiao:Int, position : Int){
        val intent = Intent(this, ExercicioDetailedActivity::class.java)
        intent.putExtra("regiao", regiao)
        intent.putExtra("position", position)
        startActivity(intent)
    }
}
