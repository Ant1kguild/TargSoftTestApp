package com.app.targsoft.test.domain.usecases

import androidx.paging.PagingData
import com.app.targsoft.test.data.api.model.Cat
import com.app.targsoft.test.domain.repository.CatRepository
import kotlinx.coroutines.flow.Flow

class GetPagingCatsUseCase(
    private val catRepository: CatRepository
) : BaseUseCaseWithOneParam<String, PagingData<Cat>> {
    override fun exec(param: String): Flow<PagingData<Cat>> = catRepository.getAllCatsStream(param)
}