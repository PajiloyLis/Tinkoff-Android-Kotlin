package com.example.example_coroutine

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import android.util.Log
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlin.math.log
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO + CoroutineName("KEK")).launch {
            val time = measureTimeMillis {
                val valOne = async{callOne() }
                val valTwo = async{ callTwo() }
                Log.d("TAG", valOne.await())
                Log.d("TAG", valTwo.await())
            }
            Log.d("TAG", "Time $time")
        }
    }

    private suspend fun callOne(): String{
        delay(1000)
        return "callOne"
    }

    private suspend fun callTwo(): String{
        delay(3000)
        return "callTwo"
    }
}