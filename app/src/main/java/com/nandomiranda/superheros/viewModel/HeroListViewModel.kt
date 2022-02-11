package com.nandomiranda.superheros.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.nandomiranda.superheros.model.api.ApiResponseStatus
import com.nandomiranda.superheros.model.api.SuperheroJsonResponse
import com.nandomiranda.superheros.model.api.service
import com.nandomiranda.superheros.model.database.getDatabase
import com.nandomiranda.superheros.model.repository.HeroListRepository
import com.nandomiranda.superheros.model.superhero.Superhero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

class HeroListViewModel(application: Application): AndroidViewModel(application) {

    private var _superheroList = MutableLiveData<MutableList<Superhero>>()

    val superheroList: LiveData<MutableList<Superhero>>
        get() = _superheroList

    private val _status = MutableLiveData<ApiResponseStatus>()
    val status: LiveData<ApiResponseStatus>
        get() = _status


    //Inicializamos la base de datos
    private val database = getDatabase(application.applicationContext)
    //creamos el repositorio que seria la comunicación del viewModel con el Model (Api)
     val repository = HeroListRepository(database)

    init {
        viewModelScope.launch {
                try {
                    //_status.value = ApiResponseStatus.LOADING
                    newSuperheroes()
                    //_status.value = ApiResponseStatus.DONE
                }catch (e:UnknownHostException){
                    _status.value = ApiResponseStatus.ERROR
                    Log.e("Error" , "No Internet Connection." , e)

                }

        }
    }

    suspend fun newSuperheroes(){
        _status.value = ApiResponseStatus.LOADING
        _superheroList.value = repository.fetchSuperhero()
        _status.value = ApiResponseStatus.DONE

    }

}