package com.app.targsoft.test.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.app.targsoft.test.domain.usecases.AddCatToFavoriteUseCase
import com.app.targsoft.test.domain.usecases.GetPagingCatsUseCase


class HomeViewModel @ViewModelInject constructor(
    private val getPagingCatsUseCase: GetPagingCatsUseCase,
    private val addCatToFavoriteUseCase : AddCatToFavoriteUseCase
) : ViewModel() {

    val streamResult = getPagingCatsUseCase.exec("Desc")
        .asLiveData(viewModelScope.coroutineContext)

}