package com.openchat.pan.domain.model

data class User(
    val id: String,
    val username: String,
    val phone: String?,
    val avatarUrl: String?,
    val signature: String?,
    val gender: String?,
    val lastOnline: Long?
) 