package com.pedrohucb.fitech.ui.activitys

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pedrohucb.fitech.databinding.ActivityListExerciciosBinding
import com.pedrohucb.fitech.models.RegiaoDosExerciciosRepository
import com.pedrohucb.fitech.ui.adapters.AdapterRegiaoExercico

class ListExerciciosActivity : AppCompatActivity() {

    private lateinit var binding : ActivityListExerciciosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListExerciciosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listViewListaDeRegioes.adapter = AdapterRegiaoExercico(this, RegiaoDosExerciciosRepository.getRegiaoDosExercicios())



        binding.iconButtonVoltarTelaListaExercicios.setOnClickListener {
            VoltarTelaAnterior()
        }

        binding.listViewListaDeRegioes.setOnItemClickListener { parent, view, position, id ->
            NavegarParaASubList(position)
        }

    }

    private fun NavegarParaASubList(position : Int){
        val intent = Intent(this, ListExerciciosSubListActivity::class.java)
        intent.putExtra("position", position)
        startActivity(intent)
    }

    private fun VoltarTelaAnterior(){
        val intent = Intent(this, TelaPrincipalActivity::class.java)
        startActivity(intent)
        finish()
    }

}