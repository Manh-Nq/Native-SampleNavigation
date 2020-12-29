package com.tapi.testnavigation.navigation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.tapi.testnavigation.R

class MyACT : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        val btGoto = findViewById<Button>(R.id.bt_goto)
        btGoto.setOnClickListener {
            val intent = Intent(this@MyACT, NavigationActivity::class.java)
            this@MyACT.startActivity(intent)
        }

    }
}