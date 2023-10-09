package com.pedrohucb.fitech.view.listexercicios.models

import com.pedrohucb.fitech.R

data class Exercicio(
    val imagem : Int,
    val tituloExercicio : String,
    val finalidadeExercicio : String,
    val dificuldadeExercicio : String
)

object ExercicioRepositorySuperiores {
    fun getExercicios(): List<Exercicio> {
        return listOf()
    }
}

object ExercicioRepositoryInferiores {
    fun getExercicios(): List<Exercicio> {
        return listOf()
    }
}

object ExercicioRepositoryAbdominais {
    fun getExercicios(): List<Exercicio> {
        return listOf()
    }
}
