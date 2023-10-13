package com.pedrohucb.fitech.view.listexercicios.models

import com.pedrohucb.fitech.R

data class Exercicio(
    val imagem : Int,
    val tituloExercicio : String,
    val finalidadeExercicio : String,
    val dificuldadeExercicio : String,
    val id : Int
)

object ExercicioRepositorySuperiores {
    fun getExercicios(): List<Exercicio> {
        return listOf(
            Exercicio(R.drawable.sup_full_pushups_img, "Flexão Completa", "Peitoral, triceps e ombro", "Dificuldade: Média", 1),
            Exercicio(R.drawable.sup_wall_pushup_img, "Flexão na parede", "Peitoral, tricpes e ombro", "Dificuldade: Fácil", 2),
            Exercicio(R.drawable.sup_knee_pushups_img, "Flexão de joelhos", "Peitoral, triceps e ombro", "Dificuldade: Fácil", 3),
            Exercicio(R.drawable.sup_incline_pushups_img, "Flexão inclinada", "Peitoral, triceps e ombro", "Dificuldade: Fácil", 4),
            Exercicio(R.drawable.sup_advanced_incline_pushups_img, "Flexão inclinada avançada", "Peitoral, triceps e ombro", "Dificuldade: Moderada", 5),
            Exercicio(R.drawable.sup_narrow_pushups_img, "Flexão fechada", "Peitoral, triceps e ombro", "Dificuldade: Média/Dificil", 6)
        )
    }
}

object ExercicioRepositoryInferiores {
    fun getExercicios(): List<Exercicio> {
        return listOf(
            Exercicio(R.drawable.inf_assisted_squats_img, "Agachamento com apoio", "Quadríceps, glúteos e músculos próximos", "Dificuldade: Fácil", 7),
            Exercicio(R.drawable.inf_half_squats_img, "Agachamento Parcial", "Quadríceps, glúteos e músculos próximos", "Dificuldade: Fácil/Médio", 8),
            Exercicio(R.drawable.inf_full_squat_img, "Agachamento Completo", "Quadríceps, glúteos e músculos próximos", "Dificuldade: Médio", 9),
            Exercicio(R.drawable.inf_assisted_one_leg_squats_img, "Agachamento de uma perna com apoio", "Quadríceps, glúteos e músculos próximos", "Dificuldade: Difícil", 10),
            Exercicio(R.drawable.inf_one_leg_squats_img, "Agachamento de uma perna", "Quadríceps, glúteos e músculos próximos", "Dificuldade: Muito Difícil", 11),
        )
    }
}

object ExercicioRepositoryAbdominais {
    fun getExercicios(): List<Exercicio> {
        return listOf(
            Exercicio(R.drawable.abd_knee_raises_img, "Elevação de joelhos", "Musculatura abdominal e lombar", "Dificuldade: Fácil", 12),
            Exercicio(R.drawable.abd_advanced_knee_raises_img, "Elevação de joelhos avançada", "Musculatura abdominal e lombar", "Dificuldade: Fácil/Média", 13),
            Exercicio(R.drawable.abd_full_leg_raises_img, "Elevação de pernas", "Musculatura abdominal e lombar", "Dificuldade: Média", 14),
            Exercicio(R.drawable.abd_hanging_knee_raises_img, "Elevação de joelhos suspensa", "Musculatura abdominal e lombar", "Dificuldade: Média/Difícil", 15),
            Exercicio(R.drawable.abd_hanging_leg_raises_img, "Elevação de pernas suspensa", "Musculatura abdominal e lombar", "Dificuldade: Difícil", 16),
        )
    }
}
