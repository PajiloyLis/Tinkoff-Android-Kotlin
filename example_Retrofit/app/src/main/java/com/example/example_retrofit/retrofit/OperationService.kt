package com.example.example_retrofit.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Part
import retrofit2.http.Path

interface IOperationService {

    @GET("android_for_beginners_back_end/main/{user}.json")
    fun getOperations(@Path("user") user: String) : Call<Operations>
}