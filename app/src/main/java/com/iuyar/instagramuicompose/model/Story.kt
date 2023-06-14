package com.iuyar.instagramuicompose.model

import androidx.compose.ui.graphics.painter.Painter
import org.w3c.dom.Text

data class Story(
    val image: Painter,
    val isOpened: Boolean,
    val userName: String
)
