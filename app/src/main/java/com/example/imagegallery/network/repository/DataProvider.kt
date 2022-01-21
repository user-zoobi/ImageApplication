package com.example.imagegallery.network.repository

import com.example.imagegallery.network.response.Pixabay

interface DataProvider {
    suspend fun fetchImage(): Pixabay
}