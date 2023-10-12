package com.pedrohucb.fitech.view.listexercicios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pedrohucb.fitech.R
import com.pedrohucb.fitech.databinding.ActivityListExerciciosBinding
import com.pedrohucb.fitech.view.listexercicios.Adapters.AdapterRegiaoExercico
import com.pedrohucb.fitech.view.listexercicios.models.RegiaoDosExerciciosRepository

class ListExercicios : AppCompatActivity() {

    private lateinit var binding : ActivityListExerciciosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListExerciciosBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.listViewListaDeRegioes.adapter = AdapterRegiaoExercico(this, RegiaoDosExerciciosRepository.getRegiaoDosExercicios())

        binding.listViewListaDeRegioes.setOnItemClickListener { parent, view, position, id ->
            NavegarParaASubList(position)
        }

    }

    private fun NavegarParaASubList(position : Int){
        val intent = Intent(this, ListExerciciosSubList::class.java)
        startActivity(intent)

        intent.putExtra("position", position)
    }

}