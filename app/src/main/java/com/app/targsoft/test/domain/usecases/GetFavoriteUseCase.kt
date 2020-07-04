package com.app.targsoft.test.domain.usecases

import com.app.targsoft.test.data.datasource.database.model.FavoriteCat
import com.app.targsoft.test.domain.repository.CatRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetFavoriteUseCase @Inject constructor(
    private val repo: CatRepository
) : BaseUseCase<List<FavoriteCat>> {
    override fun exec(): Flow<List<FavoriteCat>>  = repo.getAllFavoriteCats()
}