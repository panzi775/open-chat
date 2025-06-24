package com.pan.open.chat.ui.page

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pan.open.chat.data.local.entity.DynamicEntity

@Composable
fun DynamicPage() {
    val demoList = remember { generateDemoDynamics() }
    Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                Text(
                    text = "动态列表",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )
            }
            items(demoList) { dynamic ->
                DynamicItem(dynamic)
            }
        }
    }
}

@Composable
fun DynamicItem(dynamic: DynamicEntity) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "发布者: ${dynamic.publisherId}", style = MaterialTheme.typography.labelMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = dynamic.content, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "点赞: ${dynamic.likeCount}  评论: ${dynamic.commentCount}", style = MaterialTheme.typography.bodySmall)
        }
    }
}

fun generateDemoDynamics(): List<DynamicEntity> =
    List(50) { i ->
        DynamicEntity(
            id = i.toString(),
            publisherId = "user${i % 5 + 1}",
            content = "这是第${i + 1}条动态内容，演示用。",
            imageUrls = null,
            videoUrl = null,
            likeCount = (0..100).random(),
            commentCount = (0..20).random(),
            timestamp = System.currentTimeMillis() - i * 60000L,
            visibility = "PUBLIC"
        )
    }

@Preview()
@Composable
fun DynamicPagePreview() {
    DynamicPage()
}
