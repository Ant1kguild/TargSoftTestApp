package com.app.targsoft.test.data.repository

import androidx.paging.PagingData
import com.app.targsoft.test.data.api.model.Cat
import com.app.targsoft.test.data.datasource.database.FavoriteCatDao
import com.app.targsoft.test.data.datasource.model.FavoriteCat
import com.app.targsoft.test.data.datasource.network.RemoteCatDataSource
import com.app.targsoft.test.domain.CatRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class CatRepositoryImpl(
    private val remoteCatDataSource: RemoteCatDataSource,
    private val favoriteCatDatabase: FavoriteCatDao,
    private val ioDispatcher: CoroutineDispatcher
) : CatRepository {
    override fun getAllCatsStream(order: String): Flow<PagingData<Cat>> = remoteCatDataSource.getPager(order).flowOn(ioDispatcher)

    override fun getAllFavoriteCats(): Flow<List<FavoriteCat>> = favoriteCatDatabase.getAllFavoriteCats().flowOn(ioDispatcher)

    override fun getFavoriteCatById(id: Int): Flow<FavoriteCat> = favoriteCatDatabase.getFavoriteCat(id).flowOn(ioDispatcher)

    override suspend fun addFavoriteCat(cat: FavoriteCat) = favoriteCatDatabase.insertFavoriteCat(cat)

    override suspend fun deleteFavoriteCat(cat: FavoriteCat) = favoriteCatDatabase.deleteCat(cat)

    override suspend fun clear() = favoriteCatDatabase.deleteAll()
}