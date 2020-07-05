package com.app.targsoft.test.domain.usecases

import kotlinx.coroutines.flow.Flow

interface BaseUseCase<T : Any> {
    fun exec(): Flow<T>
}

interface BaseUseCaseWithOneParam<in A : Any, out T : Any> {
    fun exec(param: A): Flow<T>
}

interface BaseUseCaseWithTwoParam<in A : Any, in B : Any, out T : Any> {
    fun exec(firstParam: A, secondParam: B): Flow<T>
}

interface BaseUseCaseWithThreeParam<in A : Any, in B : Any, in C : Any, out T : Any> {
    fun exec(firstParam: A, secondParam: B, thirdParam: C): Flow<T>
}