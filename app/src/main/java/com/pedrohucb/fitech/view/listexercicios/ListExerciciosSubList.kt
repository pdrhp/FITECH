package com.pedrohucb.fitech.view.listexercicios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.pedrohucb.fitech.R
import com.pedrohucb.fitech.databinding.ActivityListExerciciosSubListBinding
import com.pedrohucb.fitech.view.listexercicios.Adapters.AdapterExercicio
import com.pedrohucb.fitech.view.listexercicios.models.ExercicioRepositoryAbdominais
import com.pedrohucb.fitech.view.listexercicios.models.ExercicioRepositoryInferiores
import com.pedrohucb.fitech.view.listexercicios.models.ExercicioRepositorySuperiores

class ListExerciciosSubList : AppCompatActivity() {

    private lateinit var binding : ActivityListExerciciosSubListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListExerciciosSubListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val regiao = intent.getIntExtra("position", 3)

        if(regiao == 0){
        binding.listViewListaDeExercicios.adapter = AdapterExercicio(this, ExercicioRepositorySuperiores.getExercicios())
        }
        else if(regiao == 1){
            binding.listViewListaDeExercicios.adapter = AdapterExercicio(this, ExercicioRepositoryInferiores.getExercicios())
        }
        else if(regiao == 2){
            binding.listViewListaDeExercicios.adapter = AdapterExercicio(this, ExercicioRepositoryAbdominais.getExercicios())
        }
        
        binding.listViewListaDeExercicios.setOnItemClickListener { parent, view, position, id ->
            DetalharExercicio(regiao, position)
        }


        binding.iconButtonVoltarTelaListaExercicios.setOnClickListener {
            VoltarTelaAnterior()
        }
    }

    private fun VoltarTelaAnterior(){
        val intent = Intent(this, ListExercicios::class.java)
        startActivity(intent)
        finish()
    }

    private fun DetalharExercicio(regiao:Int, position : Int){
        val intent = Intent(this, ExercicioDetailed::class.java)
        intent.putExtra("regiao", regiao)
        intent.putExtra("position", position)
        startActivity(intent)
    }
}
