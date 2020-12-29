package com.tapi.testnavigation.navigation

import android.util.Log

object Utils {
    fun log(t: String) {
        Log.e("nmCode", " ${Thread.currentThread().name}  : $t")
    }

}