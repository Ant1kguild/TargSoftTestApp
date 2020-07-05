package com.app.targsoft.test.domain.usecases

import com.app.targsoft.test.data.datasource.database.model.FavoriteCat
import com.app.targsoft.test.domain.repository.CatRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DeleteFavoriteUseCase @Inject constructor(
    private val repository: CatRepository
) : BaseUseCaseWithOneParam<FavoriteCat, Unit> {
    override fun exec(param: FavoriteCat): Flow<Unit> = repository.deleteFavoriteCat(param)
}