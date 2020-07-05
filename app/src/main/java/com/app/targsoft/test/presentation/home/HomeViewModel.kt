package com.app.targsoft.test.presentation.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.app.targsoft.test.data.datasource.database.model.FavoriteCat
import com.app.targsoft.test.domain.usecases.AddCatToFavoriteUseCase
import com.app.targsoft.test.domain.usecases.DownloadFileUseCase
import com.app.targsoft.test.domain.usecases.GetPagingCatsUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class HomeViewModel @ViewModelInject constructor(
    private val getPagingCatsUseCase: GetPagingCatsUseCase,
    private val addCatToFavoriteUseCase : AddCatToFavoriteUseCase,
    private val downloadFileUseCase: DownloadFileUseCase
) : ViewModel() {

    private val mutableToastText = MutableLiveData<String>()
    val toastText: LiveData<String> = mutableToastText

    val streamResult = getPagingCatsUseCase.exec("Desc")
        .asLiveData(viewModelScope.coroutineContext)

    fun addCatToFavorite(cat: FavoriteCat) = viewModelScope.launch {
        addCatToFavoriteUseCase.exec(cat).collect{
            mutableToastText.value = "Add cat to favorite"
        }
    }

    fun downloadFile(url:String) = viewModelScope.launch {
        downloadFileUseCase.exec(url).collect{
            mutableToastText.value = "Download file"
        }
    }
}