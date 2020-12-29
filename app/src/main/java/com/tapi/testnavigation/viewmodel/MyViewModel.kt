package com.tapi.testnavigation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tapi.testnavigation.navigation.Responstory
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    var job: Job? = null
    var res = Responstory()

    private val TAG: String = "modellog"
    private var _number = MutableLiveData<Int>()
    val number: LiveData<Int>
        get() = _number

    private var _stringLiveData = MutableLiveData<String>()
    val stringLiveData: LiveData<String>
        get() = _stringLiveData

    fun start() {
//        var result: Int = 0
//        job = viewModelScope.launch {
//            Utils.log("start launch")
//            result = res.doSomeThingA()
//            Utils.log("End launch")
//
//        }
//        _number.value = result
        viewModelScope.launch {
            runCollect()

        }
    }

    fun filter() = viewModelScope.launch {
        (1..9).asFlow().filter {
            it % 2 != 0
        }.collect {
            Log.d(TAG, "filter: $it")
        }
    }

    fun transForm() = viewModelScope.launch {
        (1..9).asFlow().transform {
            if (it % 2 != 0) {
                emit(it * 2)
            }
        }.collect {
            Log.d(TAG, "filter: $it")
        }
    }


    private fun testFlow() = flow {
        for (i in 1..9) {
            delay(1000)
            emit(i) // emit next value
        }
    }

    private fun publisher() = flow<Int> {
        for (i in 1..9) {
            delay(1000)
            emit(i)
        }
    }

    suspend fun runCollect() {
        publisher().conflate()
            .filter {
                Log.d(TAG, "filter: $it")
                it % 2 != 0
            }
            .map {
                Log.d(TAG, "map: $it")
                it * 2
            }
            .collect {
                Log.d(TAG, "collect: $it")
            }

    }
}