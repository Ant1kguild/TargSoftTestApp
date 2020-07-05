package com.app.targsoft.test.data.api.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Category(
    val id: Int,
    val name: String
)