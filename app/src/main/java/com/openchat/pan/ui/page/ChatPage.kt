package com.openchat.pan.ui.page

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ChatPage() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Text("聊天页面", style = MaterialTheme.typography.headlineMedium)
    }
}