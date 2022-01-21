package com.example.imagegallery.presentations.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BaseFactory :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val baseViewModel = BaseViewModel()
        return baseViewModel as T
    }
}