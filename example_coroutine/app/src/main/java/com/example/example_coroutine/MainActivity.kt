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
import kotlin.math.log
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO + CoroutineName("KEK")).launch {
            val time = measureTimeMillis {
                var answerOne : String? = null
                var answerTwo: String? = null
                val valOne = launch{ answerOne = callOne() }
                val valTwo = launch{ answerTwo = callTwo() }
                valOne.join()
                valTwo.join()
                Log.d("TAG", answerOne ?: "nothing")
                Log.d("TAG", answerTwo?: "nothing")
            }
            Log.d("TAG", "Time ${time}")
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