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
        return listOf(
            Exercicio(R.drawable.sup_full_pushups_img, "Flexão Completa", "Peitoral, triceps e ombro", "Dificuldade: Média"),
            Exercicio(R.drawable.sup_wall_pushup_img, "Flexão na parede", "Peitoral, tricpes e ombro", "Dificuldade: Fácil"),
            Exercicio(R.drawable.sup_knee_pushups_img, "Flexão de joelhos", "Peitoral, triceps e ombro", "Dificuldade: Fácil"),
            Exercicio(R.drawable.sup_incline_pushups_img, "Flexão inclinada", "Peitoral, triceps e ombro", "Dificuldade: Fácil"),
            Exercicio(R.drawable.sup_advanced_incline_pushups_img, "Flexão inclinada avançada", "Peitoral, triceps e ombro", "Dificuldade: Moderada"),
            Exercicio(R.drawable.sup_narrow_pushups_img, "Flexão fechada", "Peitoral, triceps e ombro", "Dificuldade: Média/Dificil")
        )
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
