package com.pdm.ai_landmark_tensorflow.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdm.ai_landmark_tensorflow.domain.Classification
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _classifications: MutableState<List<Classification>> = mutableStateOf(emptyList())

    val classifications: State<List<Classification>> = _classifications

    fun updateResults(classification: List<Classification>) {
        viewModelScope.launch {
            _classifications.value = classification
        }
    }

}