package com.example.a1.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.a1.models.ApiClient
import com.example.a1.models.JokeResponse
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class JokeViewModel : ViewModel() {

    private val _joke = mutableStateOf("Press the button to get a joke")
    val joke: State<String> get() = _joke

    fun fetchJoke() {
        viewModelScope.launch {
            try {
                val jokeResponse: JokeResponse = ApiClient.retrofitService.getJoke()
                _joke.value = jokeResponse.joke
            } catch (e: Exception) {
                Log.e("JokeViewModel", "Error fetching joke: ${e.message}", e)
                _joke.value = "Failed to load joke"
            }
        }
    }
}
