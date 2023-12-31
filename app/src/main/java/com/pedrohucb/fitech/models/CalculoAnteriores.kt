package com.pedrohucb.fitech.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CalculoAnteriores(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val resultadoCalculo: String,
    val dataCalculo: String
)
