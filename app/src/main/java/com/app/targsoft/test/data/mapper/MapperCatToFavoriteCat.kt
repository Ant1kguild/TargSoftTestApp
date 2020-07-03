package com.app.targsoft.test.data.mapper

import com.app.targsoft.test.data.api.model.Cat
import com.app.targsoft.test.data.datasource.database.model.FavoriteCat

class MapperCatToFavoriteCat : BaseMapper<Cat, FavoriteCat> {
    override fun mapTo(innData: Cat): FavoriteCat = FavoriteCat(
        id = innData.id,
        url = innData.url
    )
}