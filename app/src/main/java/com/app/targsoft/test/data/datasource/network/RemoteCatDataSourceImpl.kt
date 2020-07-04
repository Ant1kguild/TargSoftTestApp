package com.app.targsoft.test.data.datasource.network

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.app.targsoft.test.data.api.CatApiHelper
import com.app.targsoft.test.data.api.model.Cat
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteCatDataSourceImpl @Inject constructor(private val api: CatApiHelper) : RemoteCatDataSource {

    companion object {
        private const val PAGE_SIZE = 10
    }

    override fun getPager(order:String): Flow<PagingData<Cat>> =
        Pager(
            config = PagingConfig(pageSize = PAGE_SIZE),
            pagingSourceFactory = { CatSource(api, order) }
        ).flow
}