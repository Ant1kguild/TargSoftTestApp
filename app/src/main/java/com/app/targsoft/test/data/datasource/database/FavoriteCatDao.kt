package com.app.targsoft.test.data.datasource.database

import androidx.room.*
import com.app.targsoft.test.data.datasource.database.model.FavoriteCat
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteCatDao {
    @Query(value = "SELECT * FROM cat_table")
    fun getAllFavoriteCats(): Flow<List<FavoriteCat>>

    @Query(value = "SELECT * from cat_table WHERE id=:id")
    fun getFavoriteCat(id: Int): Flow<FavoriteCat>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFavoriteCat(cat: FavoriteCat)

    @Delete
    suspend fun deleteCat(cat: FavoriteCat)

    @Query(value = "DELETE FROM cat_table")
    suspend fun deleteAll()
}