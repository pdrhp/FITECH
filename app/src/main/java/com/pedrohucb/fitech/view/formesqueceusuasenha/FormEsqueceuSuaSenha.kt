package com.pedrohucb.fitech.view.formesqueceusuasenha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pedrohucb.fitech.R
import com.pedrohucb.fitech.databinding.ActivityFormEsqueceuSuaSenhaBinding

class FormEsqueceuSuaSenha : AppCompatActivity() {

    private lateinit var binding : ActivityFormEsqueceuSuaSenhaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormEsqueceuSuaSenhaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}