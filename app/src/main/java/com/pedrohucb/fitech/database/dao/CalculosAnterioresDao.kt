package com.pedrohucb.fitech.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.pedrohucb.fitech.models.CalculoAnteriores

@Dao
interface CalculosAnterioresDao {

    @Query("SELECT * FROM CalculoAnteriores")
    fun buscaTodos(): List<CalculoAnteriores>

    @Insert
    fun salva(vararg calculosAnteriores: CalculoAnteriores)

    @Query("SELECT * FROM CalculoAnteriores WHERE id = :id")
    fun buscaPorID(id: Long) : CalculoAnteriores?
}