package com.app.targsoft.test.data.datasource.network

import android.content.Context
import android.os.Environment
import android.os.Environment.DIRECTORY_DOWNLOADS
import com.downloadservice.filedownloadservice.manager.FileDownloadManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.File
import java.security.MessageDigest

class AndroidFileDownloader(private val context: Context) : FileDownloaderDataSource {

    override fun isFileDownloaded(fileUrl: String): Boolean {
        val filePath = createHashFileName(fileUrl)
        val directory = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
        return File("${directory}/${filePath}").isFile
    }

    override fun startDownloadFile(fileUrl: String): Flow<Unit> = flow {
        FileDownloadManager.initDownload(
            context = context,
            fileUrl = fileUrl,
            filePath = context.getExternalFilesDir(DIRECTORY_DOWNLOADS)?.absolutePath ?: throw Exception(""),
            fileName = createHashFileName(fileUrl)
        ).apply { emit(this) }
    }

    private fun createHashFileName(fileUrl: String): String {
        val postfix = when {
            fileUrl.contains(".jpg") -> ".jpg"
            fileUrl.contains(".gif") -> ".gif"
            fileUrl.contains(".png") -> ".png"
            else -> throw Exception("Unknown file type")
        }
        val bytes = fileUrl.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytes)
        val hashString = digest.fold("", { str, it -> str + "%02x".format(it) })
        return "${hashString}.${postfix}"
    }
}