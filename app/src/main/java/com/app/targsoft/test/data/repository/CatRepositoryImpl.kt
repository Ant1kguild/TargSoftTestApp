package com.app.targsoft.test.data.repository

import androidx.paging.PagingData
import com.app.targsoft.test.data.api.model.Cat
import com.app.targsoft.test.data.datasource.network.CatDataSource
import com.app.targsoft.test.domain.CatRepository
import kotlinx.coroutines.flow.Flow

class CatRepositoryImpl(private val data: CatDataSource) : CatRepository {
    override fun getCatResultStream(order:String): Flow<PagingData<Cat>> {
        return data.getPager(order)
    }
}