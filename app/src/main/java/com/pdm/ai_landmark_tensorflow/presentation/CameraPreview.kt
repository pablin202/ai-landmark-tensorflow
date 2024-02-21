package com.pdm.ai_landmark_tensorflow.presentation

import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun CameraPreview(
    controller: LifecycleCameraController,
    modifier: Modifier
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val primaryColor = MaterialTheme.colorScheme.primary

    AndroidView(
        factory = {
            PreviewView(it).apply {
                this.controller = controller
                controller.bindToLifecycle(lifecycleOwner)
            }
        }, modifier = modifier
    )

    Canvas(
        modifier = Modifier
            .fillMaxSize()
    ) {

        val blurRadius = 25f
        val squareSize = size.minDimension * 0.8f
        val squareTopLeft = Offset((size.width - squareSize) / 2, (size.height - squareSize) / 2)

        drawRoundRect(
            color = primaryColor,
            topLeft = Offset(squareTopLeft.x - blurRadius, squareTopLeft.y - blurRadius),
            size = Size(squareSize + blurRadius * 2, squareSize + blurRadius * 2),
            style = Stroke(width = 6.dp.toPx()),
            cornerRadius = CornerRadius(50f, 50f)
        )
    }
}