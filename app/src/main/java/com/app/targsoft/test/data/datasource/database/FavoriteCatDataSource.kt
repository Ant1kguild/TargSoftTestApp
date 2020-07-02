package com.app.targsoft.test.data.datasource.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.targsoft.test.data.datasource.model.FavoriteCat

@Database(entities = [FavoriteCat::class], version = 1, exportSchema = false)
abstract class FavoriteCatDataSource : RoomDatabase() {
    abstract fun animalDao(): FavoriteCatDao

    companion object{
        @Volatile
        private var INSTANCE: FavoriteCatDataSource? = null

        fun getDatabase(context: Context): FavoriteCatDataSource {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FavoriteCatDataSource::class.java,
                    "animals_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}