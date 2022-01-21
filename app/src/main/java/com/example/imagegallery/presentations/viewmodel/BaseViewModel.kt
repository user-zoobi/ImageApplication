package com.example.imagegallery.presentations.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imagegallery.network.repository.MainRepository
import com.example.imagegallery.network.response.Pixabay
import com.example.imagegallery.extensions.Constants.ERROR
import com.example.imagegallery.extensions.Constants.VM_ERROR
import com.example.imagegallery.extensions.Constants.VM_LOADER
import com.example.imagegallery.extensions.Constants.VM_SUCCESS
import com.example.imagegallery.network.response.Response
import kotlinx.coroutines.launch

class BaseViewModel : ViewModel() {

    val repository = MainRepository()
    val _images = MutableLiveData<Response<Pixabay>>()
    val images: LiveData<Response<Pixabay>>
    get() = _images

    fun getImages(){

        viewModelScope.launch {
            _images.value = Response.loading()
            Log.d(VM_LOADER,"Loading")

            try {
                Log.d(VM_SUCCESS,"Response Coming")
                val response = Response.success(repository.fetchImage())
                _images.value = response
            }

            catch (e:Exception){
                Log.d(VM_ERROR,"${e.message}")
                _images.value = Response.error("${e.message}",null)
            }
        }

    }
}