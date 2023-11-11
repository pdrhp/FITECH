package com.pedrohucb.fitech.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pedrohucb.fitech.database.dao.CalculosAnterioresDao
import com.pedrohucb.fitech.models.CalculoAnteriores

@Database(entities = [CalculoAnteriores::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun calculosAnterioresDao(): CalculosAnterioresDao

    companion object {
        fun instacia(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "fitech.db"
            ).build()
        }
    }
}