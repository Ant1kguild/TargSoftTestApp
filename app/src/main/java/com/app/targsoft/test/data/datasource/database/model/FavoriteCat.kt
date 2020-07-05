package com.app.targsoft.test.data.datasource.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cat_table")
data class FavoriteCat(
    @PrimaryKey
    val id: String,
    val url: String
)