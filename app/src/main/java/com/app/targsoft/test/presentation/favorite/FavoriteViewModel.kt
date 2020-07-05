package com.app.targsoft.test.presentation.favorite

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.app.targsoft.test.data.datasource.database.model.FavoriteCat
import com.app.targsoft.test.domain.usecases.DeleteFavoriteUseCase
import com.app.targsoft.test.domain.usecases.GetFavoriteUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FavoriteViewModel @ViewModelInject constructor(
    private val getFavoriteUseCase: GetFavoriteUseCase,
    private val deleteFavoriteUseCase: DeleteFavoriteUseCase
) : ViewModel() {

    private val mutableToastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String> = mutableToastMessage

    val favoriteCats = getFavoriteUseCase.exec().asLiveData(viewModelScope.coroutineContext)

    fun deleteFavorite(cat:FavoriteCat)= viewModelScope.launch {
        deleteFavoriteUseCase.exec(cat).collect{
            mutableToastMessage.value = "Delete caf from favorite"
        }
    }
}