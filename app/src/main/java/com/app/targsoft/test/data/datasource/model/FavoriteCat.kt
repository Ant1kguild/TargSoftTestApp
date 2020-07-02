package com.app.targsoft.test.data.datasource.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cat_table")
data class FavoriteCat(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    val url: String,
    val heightImage: Int,
    val widthImage: Int
)