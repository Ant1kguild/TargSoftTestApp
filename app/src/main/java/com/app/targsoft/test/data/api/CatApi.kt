package com.app.targsoft.test.data.api

import com.app.targsoft.test.data.api.model.Cat
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

interface CatApi {
    @GET("images/search")
    suspend fun getPaginationCats(
        @Query("limit") limit: Int,
        @Query("page") page: Int,
        @Query("order") order: String
    ): List<Cat>
}

interface CatApiHelper {
    suspend fun getPaginationCats(
        limit: Int,
        page: Int,
        order: String
    ): List<Cat>
}

class CatApiHelperImpl @Inject constructor(private val api: CatApi) : CatApiHelper {
    override suspend fun getPaginationCats(limit: Int, page: Int, order: String): List<Cat> {
        return api.getPaginationCats(limit, page, order)
    }

}