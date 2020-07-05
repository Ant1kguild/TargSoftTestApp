package com.app.targsoft.test.data.repository

import android.util.Log
import androidx.paging.PagingData
import com.app.targsoft.test.data.datasource.database.FavoriteCatDao
import com.app.targsoft.test.data.datasource.database.model.FavoriteCat
import com.app.targsoft.test.data.datasource.network.RemoteCatDataSource
import com.app.targsoft.test.data.mapper.MapperCatToFavoriteCat
import com.app.targsoft.test.domain.repository.CatRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CatRepositoryImpl @Inject constructor(
    private val remoteCatDataSource: RemoteCatDataSource,
    private val favoriteCatDatabase: FavoriteCatDao,
    private val mapper: MapperCatToFavoriteCat,
    private val ioDispatcher: CoroutineDispatcher
) : CatRepository {
    override fun getAllCatsStream(order: String): Flow<PagingData<FavoriteCat>> =
        remoteCatDataSource.getPager(order)
            .map { it.map { cat -> mapper.map(cat) } }
            .flowOn(ioDispatcher)

    override fun getAllFavoriteCats(): Flow<List<FavoriteCat>> =
        favoriteCatDatabase.getAllFavoriteCats()
            .flowOn(ioDispatcher)

    override fun getFavoriteCatById(id: Int): Flow<FavoriteCat> = favoriteCatDatabase.getFavoriteCat(id).flowOn(ioDispatcher)

    override fun addFavoriteCat(cat: FavoriteCat): Flow<Unit> = flow {
        try {
            favoriteCatDatabase.insertFavoriteCat(cat)
            emit(Unit)
        } catch (e: Exception) {
            Log.e("Test", "Message: ${e.message}")
            emit(Unit)
        }
    }.flowOn(ioDispatcher)

    override fun deleteFavoriteCat(cat: FavoriteCat): Flow<Unit> = flow { emit(favoriteCatDatabase.deleteCat(cat)) }.flowOn(ioDispatcher)

    override fun clear(): Flow<Unit> = flow { emit(favoriteCatDatabase.deleteAll()) }.flowOn(ioDispatcher)
}