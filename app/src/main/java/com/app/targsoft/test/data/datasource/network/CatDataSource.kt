package com.app.targsoft.test.data.datasource.network

import androidx.paging.PagingData
import com.app.targsoft.test.data.api.model.Cat
import kotlinx.coroutines.flow.Flow

interface CatDataSource {
    fun getPager(order:String) : Flow<PagingData<Cat>>
}