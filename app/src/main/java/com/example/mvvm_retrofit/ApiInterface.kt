package com.example.mvvm_retrofit

import com.example.mvvm_retrofit.model.UserItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("/users")
    fun getData() : Call<List<UserItem>>
}