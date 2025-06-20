package com.openchat.pan.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dynamics")
data class DynamicEntity(
    @PrimaryKey val id: String,
    val publisherId: String,
    val content: String,
    val imageUrls: String?, // 逗号分隔
    val videoUrl: String?,
    val likeCount: Int,
    val commentCount: Int,
    val timestamp: Long,
    val visibility: String
) 