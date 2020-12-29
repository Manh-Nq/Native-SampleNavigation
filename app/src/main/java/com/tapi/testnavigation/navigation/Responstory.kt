package com.tapi.testnavigation.navigation

import kotlinx.coroutines.*

class Responstory {


    suspend fun doSomeThingA(): Int = coroutineScope {
        val startTime = System.currentTimeMillis()
        Utils.log("A call B")
        val valueB: Deferred<Int> = async {
            doSomeThingB()
        }
        Utils.log("A call B done")

        Utils.log("A call C")
        val valueC = async { doSomeThingC() }
        Utils.log("A call C done")
        val endTIme = System.currentTimeMillis()
        Utils.log("end time to${endTIme - startTime}")
        valueB.await() + valueC.await()

    }

    suspend fun doSomeThingB(): Int = withContext(Dispatchers.Default) {
        Utils.log("B start")
        for (i in 0 until 5) {

            Thread.sleep(400)
            if (isActive) {
                return@withContext 0
            }
            Utils.log("B i'm running")
        }
        Utils.log("B end")
        8
    }

    suspend fun doSomeThingC(): Int = withContext(Dispatchers.Default) {
        Utils.log("C start")
        Thread.sleep(1000)
        Utils.log("C end")
        10
    }


}