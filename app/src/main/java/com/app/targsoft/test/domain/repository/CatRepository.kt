package com.app.targsoft.test.domain.repository

import androidx.paging.PagingData
import com.app.targsoft.test.data.datasource.database.model.FavoriteCat
import kotlinx.coroutines.flow.Flow

interface CatRepository {
    fun getAllCatsStream(order: String): Flow<PagingData<FavoriteCat>>
    fun getAllFavoriteCats(): Flow<List<FavoriteCat>>
    fun getFavoriteCatById(id: Int): Flow<FavoriteCat>
    fun addFavoriteCat(cat: FavoriteCat): Flow<Unit>
    fun deleteFavoriteCat(cat: FavoriteCat): Flow<Unit>
    fun clear(): Flow<Unit>

}