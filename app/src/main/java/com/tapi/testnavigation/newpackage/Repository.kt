package com.tapi.testnavigation.newpackage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tapi.testnavigation.navigation.Utils.log
import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.coroutines.resume

class Repository {
    private val _list = MutableLiveData<List<String>>()
    val list: LiveData<List<String>> = _list
    init {
        val result = mutableListOf<String>()
        for (i in 0 until 10) result.add("Item $i")
        _list.value = result
    }
    suspend fun delete() = coroutineScope {
        val deletes = _list.value?.dropLast(5) ?: mutableListOf()
        val deferreds = mutableListOf<Deferred<String?>>()
        deletes.forEach { item ->
            deferreds.add(async { delete(item) })
        }
        val deleteCompleted = deferreds.awaitAll().filterNotNull()
        val result = _list.value as ArrayList
        result.removeAll(deleteCompleted)
        _list.value = result
        log("delete function done")
    }
    private suspend fun delete(item: String): String? =
        suspendCancellableCoroutine { continuation ->
            FileManager.delete(item) {
                log("$item event = $it")
                if (it == Event.DELETE)
                    continuation.resume(item)
                else if(it == Event.FAIL)
                    continuation.resume(null)
            }
        }
    private fun removeItem(item: String) {
        val list = _list.value as ArrayList
        list.remove(item)
        _list.postValue(list)
    }
}