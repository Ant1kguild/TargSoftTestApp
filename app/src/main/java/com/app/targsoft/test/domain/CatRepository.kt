package com.app.targsoft.test.domain

import androidx.paging.PagingData
import com.app.targsoft.test.data.model.Cat
import kotlinx.coroutines.flow.Flow

interface CatRepository {
    fun getCatResultStream(order: String): Flow<PagingData<Cat>>
}