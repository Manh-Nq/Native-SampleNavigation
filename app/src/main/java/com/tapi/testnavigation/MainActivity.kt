package com.tapi.testnavigation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        val btGoto = findViewById<Button>(R.id.bt_goto)
        btGoto.setOnClickListener {
            val intent = Intent(this@MainActivity, NavigationActivity::class.java)
            this@MainActivity.startActivity(intent)
        }

    }
}