package com.app.targsoft.test.data.api.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Cat(
    val id: String,
    val url: String
)