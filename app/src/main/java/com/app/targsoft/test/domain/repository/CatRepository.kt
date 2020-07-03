package com.app.targsoft.test.domain.repository

import androidx.paging.PagingData
import com.app.targsoft.test.data.api.model.Cat
import com.app.targsoft.test.data.datasource.database.model.FavoriteCat
import kotlinx.coroutines.flow.Flow

interface CatRepository {
    fun getAllCatsStream(order: String): Flow<PagingData<Cat>>
    fun getAllFavoriteCats() : Flow<List<FavoriteCat>>
    fun getFavoriteCatById(id: Int) : Flow<FavoriteCat>
    suspend fun addFavoriteCat(cat: FavoriteCat)
    suspend fun deleteFavoriteCat(cat: FavoriteCat)
    suspend fun clear()

}