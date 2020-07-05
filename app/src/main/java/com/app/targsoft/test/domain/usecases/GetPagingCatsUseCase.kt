package com.app.targsoft.test.domain.usecases

import androidx.paging.PagingData
import com.app.targsoft.test.data.datasource.database.model.FavoriteCat
import com.app.targsoft.test.domain.repository.CatRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPagingCatsUseCase @Inject constructor(
    private val catRepository: CatRepository
) : BaseUseCaseWithOneParam<String, PagingData<FavoriteCat>> {
    override fun exec(param: String): Flow<PagingData<FavoriteCat>> = catRepository.getAllCatsStream(param)
}