package com.app.targsoft.test.presentation.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.app.targsoft.test.data.datasource.database.model.FavoriteCat
import com.app.targsoft.test.domain.usecases.AddCatToFavoriteUseCase
import com.app.targsoft.test.domain.usecases.GetPagingCatsUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class HomeViewModel @ViewModelInject constructor(
    private val getPagingCatsUseCase: GetPagingCatsUseCase,
    private val addCatToFavoriteUseCase : AddCatToFavoriteUseCase
) : ViewModel() {

    val streamResult = getPagingCatsUseCase.exec("Desc")
        .asLiveData(viewModelScope.coroutineContext)

    fun addCatToFavorite(cat: FavoriteCat) = viewModelScope.launch {
        addCatToFavoriteUseCase.exec(cat).collect()
    }
}