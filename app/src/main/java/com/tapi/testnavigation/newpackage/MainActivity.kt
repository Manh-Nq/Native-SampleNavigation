package com.tapi.testnavigation.newpackage

import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.tapi.testnavigation.R
import com.tapi.testnavigation.navigation.Utils.log


class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    var isDone = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.state.observe(this) {
            isDone = it
            log("$it")
        }


        viewModel.list.observe(this) {
            if (isDone) {
                log("Total number = ${it.size}")
                it.forEach {
                    log(it)
                }
            }
        }
        initViews()
    }

    private fun initViews() {
        val btGoto = findViewById<Button>(R.id.bt_goto)
//        btGoto.setOnClickListener {
        /*  val intent = Intent(this@MainActivity, NavigationActivity::class.java)
          this@MainActivity.startActivity(intent)*/
//            viewModel.delete()
//        }
        btGoto.setOnClickListener {
            viewModel.delete()
        }

    }
}