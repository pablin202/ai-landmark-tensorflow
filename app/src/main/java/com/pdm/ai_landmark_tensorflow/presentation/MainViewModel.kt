package com.pdm.ai_landmark_tensorflow.presentation

import androidx.camera.view.LifecycleCameraController
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.pdm.ai_landmark_tensorflow.data.TfLiteLandmarkClassifier
import com.pdm.ai_landmark_tensorflow.domain.Classification

class MainViewModel : ViewModel() {

    val classifications: MutableState<List<Classification>> = mutableStateOf(emptyList())

}