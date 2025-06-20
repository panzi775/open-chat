package com.openchat.pan.domain.model

data class Group(
    val id: String,
    val name: String,
    val avatarUrl: String?,
    val announcement: String?,
    val ownerId: String,
    val memberIds: List<String>
) 