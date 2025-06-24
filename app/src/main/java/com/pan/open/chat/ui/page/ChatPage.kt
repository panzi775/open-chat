package com.pan.open.chat.ui.page

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ChatPage() {
    // 可以调用 ConversationListPage 来展示会话列表
    ConversationListPage()
}


// conversation 列表
@Composable
fun ConversationListPage() {
    // 列表
    // 这里可以使用 LazyColumn 或者其他列表组件来展示会话列表
    // 目前先简单展示一个文本
    LazyColumn {
        item {
            Text("聊天页面", style = MaterialTheme.typography.headlineMedium)
        }
        item {
            Text("会话列表", style = MaterialTheme.typography.bodyLarge)
        }
        // 这里可以添加更多的会话项
        items(10) { index ->
            Text("会话 $index", style = MaterialTheme.typography.bodyMedium)
        }
    }
}