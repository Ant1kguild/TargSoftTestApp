package com.app.targsoft.test.data.datasource.network

import androidx.paging.PagingSource
import com.app.targsoft.test.data.api.CatApiHelper
import com.app.targsoft.test.data.api.model.Cat
import retrofit2.HttpException
import java.io.IOException


class CatSource(private val api: CatApiHelper, private val order: String) : PagingSource<Int, Cat>() {

    companion object {
        private const val START_PAGE_INDEX = 1
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Cat> {
        val position = params.key ?: START_PAGE_INDEX
        return try {
            val result = api.getPaginationCats(limit = params.loadSize, page = position, order = order)
            LoadResult.Page(
                data = result,
                prevKey = if (position == START_PAGE_INDEX) null else position - 1,
                nextKey = if (result.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

}