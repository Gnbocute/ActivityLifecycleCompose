package br.edu.ifsp.scl.prdm.sc3046664.activitylifecyclecompose

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel(val savedStateHandle: SavedStateHandle): ViewModel() {
    private companion object{
        const val USER_KEY = "user"
    }

    private val _uiState = MutableStateFlow(savedStateHandle[USER_KEY] ?: User())
    val uiState: StateFlow<User> = _uiState.asStateFlow()

    fun updateName(name: String){
        _uiState.update { it.copy(name = name) }
        savedStateHandle[USER_KEY] =
            _uiState.value
    }

    fun updateAge(age: Int){
        _uiState.update { it.copy(age = age) }
        savedStateHandle[USER_KEY] =
            _uiState.value.copy(age = age)
    }
}