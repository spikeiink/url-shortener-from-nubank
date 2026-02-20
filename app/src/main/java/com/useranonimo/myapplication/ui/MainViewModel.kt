package com.useranonimo.myapplication.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.useranonimo.myapplication.data.RetrofitInstance
import com.useranonimo.myapplication.data.UrlResponse
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _urls = MutableLiveData<List<UrlResponse>>(emptyList())
    val urls: LiveData<List<UrlResponse>> = _urls

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun shortenUrl(url: String) {
        _loading.value = true

        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.shortenUrl(
                    request = com.useranonimo.myapplication.data.ShortenRequest(url)
                )

                val updatedList = _urls.value.orEmpty().toMutableList()
                updatedList.add(0, response)
                _urls.value = updatedList
                _error.value = null

            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _loading.value = false
            }
        }
    }

}

