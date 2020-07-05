package com.app.targsoft.test.domain.usecases

import com.app.targsoft.test.domain.repository.FileDownloadRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class DownloadFileUseCase @Inject constructor(
    private val fileDownloadRepository: FileDownloadRepository
)  : BaseUseCaseWithOneParam<String, Unit> {
    override fun exec(param: String): Flow<Unit> = fileDownloadRepository.startDownloadFile(param)
}