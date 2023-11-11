package com.pedrohucb.fitech.models

import com.pedrohucb.fitech.R

data class RegiaoDosExercicios(
    val imagem : Int,
    val tipoExercicio : TipoExercicio
)

object RegiaoDosExerciciosRepository{
    fun getRegiaoDosExercicios(): List<RegiaoDosExercicios> {
        return listOf(
            RegiaoDosExercicios(R.drawable.regiao_superior, TipoExercicio.REGIAOSUPERIOR),
            RegiaoDosExercicios(R.drawable.regiao_inferior, TipoExercicio.REGIAOINFERIOR),
            RegiaoDosExercicios(R.drawable.regiao_abdominal, TipoExercicio.REGIAOABDOMINAL)
        )
    }
}
