package com.example.healthsupport.ui.screen.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Registro::class], version = 1)
abstract class DatabaseRegistro : RoomDatabase() {
    abstract  fun getDaoRegistro(): DaoRegistro


    companion object{
        private var INSTANCE: DatabaseRegistro? = null

        fun getInstance(context: Context): DatabaseRegistro{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room
                        .databaseBuilder(
                            context = context,
                            klass = DatabaseRegistro::class.java,
                            name = "db_registro"
                        ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}