package com.example.mvvm_retrofit.repository

import com.example.mvvm_retrofit.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserRepository {

    private val BASE_URL = "https://api.github.com"
    private val api: ApiInterface

    init {
        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()

        api = retrofit.create(ApiInterface::class.java)
    }

    fun getUsers() = api.getData()
}