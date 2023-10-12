package com.pedrohucb.fitech.view.listexercicios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pedrohucb.fitech.R
import com.pedrohucb.fitech.databinding.ActivityListExerciciosSubListBinding

class ListExerciciosSubList : AppCompatActivity() {

    private lateinit var binding : ActivityListExerciciosSubListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListExerciciosSubListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position = intent.getIntExtra("position", 3)

        if(position == 0){
            binding.listViewListaDeExercicios.adapter
        }



    }
}