package com.app.targsoft.test.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.app.targsoft.test.domain.repository.CatRepository


class HomeViewModel @ViewModelInject constructor(
    private val catRepository: CatRepository
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    val streamResult = catRepository.getAllCatsStream("Desc").cachedIn(viewModelScope)
}