package com.app.targsoft.test.data.datasource

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.app.targsoft.test.data.api.CatApiHelper
import com.app.targsoft.test.data.model.Cat
import kotlinx.coroutines.flow.Flow

class CatDataSourceImpl(private val api: CatApiHelper) : CatDataSource {

    companion object {
        private const val PAGE_SIZE = 10
    }

    override fun getPager(order:String): Flow<PagingData<Cat>> =
        Pager(
            config = PagingConfig(pageSize = PAGE_SIZE),
            pagingSourceFactory = { CatSource(api, order) }
        ).flow
}