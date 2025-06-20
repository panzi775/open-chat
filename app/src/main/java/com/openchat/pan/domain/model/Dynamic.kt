package com.openchat.pan.domain.model

data class Dynamic(
    val id: String,
    val publisherId: String,
    val content: String,
    val imageUrls: List<String>?,
    val videoUrl: String?,
    val likeCount: Int,
    val commentCount: Int,
    val timestamp: Long,
    val visibility: DynamicVisibility
)

enum class DynamicVisibility {
    PUBLIC, FRIENDS, PARTIAL, PRIVATE
} 