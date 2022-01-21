package com.example.imagegallery.network.api

import com.example.imagegallery.network.response.Pixabay
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiNetwork {
    @GET(HostUrl.ENDPOINT)
    suspend fun fetchImages(
        @Query("key") key:String = "23007366-58b2248a74d6c440e2f602034"
    ): Pixabay
}