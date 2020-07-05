package com.app.targsoft.test.data.datasource.network

import kotlinx.coroutines.flow.Flow

interface FileDownloaderDataSource {
    fun startDownloadFile(fileUrl: String): Flow<Unit>
    fun isFileDownloaded(fileUrl: String) : Boolean
}