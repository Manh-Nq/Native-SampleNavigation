package com.tapi.testnavigation.newpackage

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val repository = Repository()

    val list: LiveData<List<String>> = repository.list
    val state: LiveData<Boolean> = repository.state
    var job: Job? = null

    fun delete() {
        viewModelScope.launch {
            repository.delete()
        }
    }

}