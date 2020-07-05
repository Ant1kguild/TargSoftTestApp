package com.app.targsoft.test.domain.repository

import kotlinx.coroutines.flow.Flow

interface FileDownloadRepository {
   fun startDownloadFile(fileUrl: String): Flow<Unit>
}