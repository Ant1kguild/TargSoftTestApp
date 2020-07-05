package com.app.targsoft.test.data.repository

import com.app.targsoft.test.data.datasource.network.FileDownloaderDataSource
import com.app.targsoft.test.domain.repository.FileDownloadRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FileDownloadRepositoryImp @Inject constructor(
    private val fileDownloaderDataSource: FileDownloaderDataSource
) : FileDownloadRepository {

    override fun startDownloadFile(fileUrl: String): Flow<Unit> =
        if (fileDownloaderDataSource.isFileDownloaded(fileUrl)) {
            flow { emit(Unit) }
        } else {
            fileDownloaderDataSource.startDownloadFile(fileUrl)
        }


}