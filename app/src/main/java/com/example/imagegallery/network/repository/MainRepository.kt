package com.example.imagegallery.network.repository

import com.example.imagegallery.network.api.RetrofitClient
import com.example.imagegallery.network.response.Pixabay

class MainRepository:DataProvider {
    override suspend fun fetchImage(): Pixabay {
        return RetrofitClient.apiNetwork.fetchImages()
    }
}