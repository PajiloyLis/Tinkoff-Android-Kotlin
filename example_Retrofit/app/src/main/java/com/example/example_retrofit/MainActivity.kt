package com.example.example_retrofit

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.example_retrofit.retrofit.IOperationService
import com.example.example_retrofit.retrofit.Operations
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        getOperations()
    }

    private fun getOperations() {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val contentType = "application/json".toMediaType()
        val client = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

        val retrofit = Retrofit.Builder().client(client).addConverterFactory(Json.asConverterFactory(contentType)).baseUrl(BASE_URL).build()
        val service = retrofit.create(IOperationService::class.java)

        service.getOperations("Олег").enqueue(object : Callback<Operations> {
            override fun onResponse(call: Call<Operations>, response: Response<Operations>) {
                if (response.isSuccessful) {
                    val operations = response.body()
                    Log.i(TAG, operations.toString())
                } else {

                }
            }

            override fun onFailure(call: Call<Operations>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    private companion object {
        const val BASE_URL = "https://raw.githubusercontent.com/InternetEducation/"
        const val TAG = "MainActivity"
    }
}