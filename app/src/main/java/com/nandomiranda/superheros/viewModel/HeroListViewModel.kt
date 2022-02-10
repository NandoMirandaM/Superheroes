package com.nandomiranda.superheros.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.nandomiranda.superheros.model.api.SuperheroJsonResponse
import com.nandomiranda.superheros.model.api.service
import com.nandomiranda.superheros.model.database.getDatabase
import com.nandomiranda.superheros.model.repository.HeroListRepository
import com.nandomiranda.superheros.model.superhero.Superhero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HeroListViewModel(application: Application): AndroidViewModel(application) {
    private var _superheroList = MutableLiveData<MutableList<Superhero>>()

    val superheroList: LiveData<MutableList<Superhero>>
        get() = _superheroList

    //Inicializamos la base de datos
    private val database = getDatabase(application.applicationContext)
    //creamos el repositorio que seria la comunicación del viewModel con el Model (Api)
     val repository = HeroListRepository(database)

    init {
        viewModelScope.launch {
                //_superheroList.value = repository.fetchSuperhero()
            newMetodo()
        }
    }

    suspend fun newMetodo(){
        _superheroList.value = repository.fetchSuperhero()
    }

}