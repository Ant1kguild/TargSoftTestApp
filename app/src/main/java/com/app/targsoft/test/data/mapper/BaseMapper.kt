package com.app.targsoft.test.data.mapper

interface BaseMapper<in A : Any, out B : Any> {
    fun map(innData: A): B
}