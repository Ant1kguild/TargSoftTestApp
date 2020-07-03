package com.app.targsoft.test.data.datasource.database.model

import androidx.room.Entity

@Entity(tableName = "cat_table")
data class FavoriteCat(
    val id : String,
    val url: String
)