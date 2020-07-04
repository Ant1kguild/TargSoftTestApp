package com.app.targsoft.test.domain.usecases

import kotlinx.coroutines.flow.Flow

class DownloadFileUseCase : BaseUseCaseWithOneParam<String, Unit> {
    override fun exec(param: String): Flow<Unit> {
        TODO("Not yet implemented")
    }
}