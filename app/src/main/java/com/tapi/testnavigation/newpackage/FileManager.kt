package com.tapi.testnavigation.newpackage

import kotlin.concurrent.thread
import kotlin.random.Random

enum class Event {
    OPEN, FAIL, DELETE
}


object FileManager {
    fun delete(path: String, listener: (Event) -> Unit) {
        thread {
            Thread.sleep(100)
            listener(Event.OPEN)
            Thread.sleep(200)
            if (Random.nextBoolean()) {
                listener(Event.DELETE)
            } else
                listener(Event.FAIL)
        }
    }
}