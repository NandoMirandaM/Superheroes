package com.nandomiranda.superheros.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nandomiranda.superheros.model.superhero.Superhero
import kotlinx.coroutines.launch

class HeroListViewModel: ViewModel() {
    private var _superheroList = MutableLiveData<MutableList<Superhero>>()

    val superheroList: LiveData<MutableList<Superhero>>
        get() = _superheroList

    init {
        viewModelScope.launch {
            //_superheroList.value = repository.fetchMovie()
        }
    }
}