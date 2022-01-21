package com.example.imagegallery.network.api

import com.example.imagegallery.network.api.HostUrl.Companion.BASEURL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    val apiNetwork:ApiNetwork by lazy {
        retrofit.create(ApiNetwork::class.java)
    }
}