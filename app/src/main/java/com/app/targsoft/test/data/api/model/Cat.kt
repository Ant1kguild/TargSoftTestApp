package com.app.targsoft.test.data.api.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Cat(
    val breeds: List<Breed> = emptyList(),
    val categories: List<Category> = emptyList(),
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)