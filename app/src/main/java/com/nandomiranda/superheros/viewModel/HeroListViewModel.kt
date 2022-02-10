package com.nandomiranda.superheros.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nandomiranda.superheros.model.api.SuperheroJsonResponse
import com.nandomiranda.superheros.model.api.service
import com.nandomiranda.superheros.model.repository.HeroListRepository
import com.nandomiranda.superheros.model.superhero.Superhero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HeroListViewModel: ViewModel() {
    private var _superheroList = MutableLiveData<MutableList<Superhero>>()

    val superheroList: LiveData<MutableList<Superhero>>
        get() = _superheroList

    //creamos el repositorio que seria la comunicación del viewModel con el Model (Api)
    private val repository = HeroListRepository()

    init {
        viewModelScope.launch {
                _superheroList.value = repository.fetchSuperhero()
            // repository.fetchMovie()
        }
    }

}