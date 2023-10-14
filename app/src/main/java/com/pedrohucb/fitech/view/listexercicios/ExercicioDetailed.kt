package com.pedrohucb.fitech.view.listexercicios

import android.content.Intent
import android.media.MediaPlayer.OnCompletionListener
import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import com.pedrohucb.fitech.databinding.ActivityExercicioDetailedBinding
import com.pedrohucb.fitech.view.listexercicios.models.Exercicio
import com.pedrohucb.fitech.view.listexercicios.models.ExercicioRepositoryAbdominais
import com.pedrohucb.fitech.view.listexercicios.models.ExercicioRepositoryInferiores
import com.pedrohucb.fitech.view.listexercicios.models.ExercicioRepositorySuperiores


class ExercicioDetailed : AppCompatActivity() {

    private lateinit var binding : ActivityExercicioDetailedBinding
    private lateinit var exercicioList : List<Exercicio>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExercicioDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val positionList = intent.getIntExtra("position", 15)
        val regiao = intent.getIntExtra("regiao", 3)

        if(regiao == 0){
            exercicioList = ExercicioRepositorySuperiores.getExercicios()
        }
        else if(regiao == 1){
            exercicioList = ExercicioRepositoryInferiores.getExercicios()
        }
        else if(regiao == 2){
            exercicioList = ExercicioRepositoryAbdominais.getExercicios()
        }

        binding.iconButtonVoltarTelaExercicioDetailed.setOnClickListener {
            VoltarTelaAnterior(regiao)
        }

        val video = exercicioList[positionList].videoPackage
        val videoURI = Uri.parse("android.resource://${packageName}/${video}")

        val mediaController = MediaController(this)
        mediaController.setAnchorView(binding.videoViewExercicio)

        binding.videoViewExercicio.setOnCompletionListener(OnCompletionListener {
            binding.videoViewExercicio.start()
        })


        binding.videoViewExercicio.setMediaController(mediaController)
        binding.videoViewExercicio.setVideoURI(videoURI)


        binding.titleExercicioDetailed.text = exercicioList[positionList].tituloExercicio
        binding.descricaoExercicioDetailed.text = exercicioList[positionList].descricaoExercicio
        binding.videoViewExercicio.start()
    }

    private fun VoltarTelaAnterior(regiao : Int){
        val intent = Intent(this, ListExerciciosSubList::class.java)
        intent.putExtra("position", regiao)
        startActivity(intent)
        finish()
    }
}