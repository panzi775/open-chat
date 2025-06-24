package com.pan.open.chat.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: String,
    val username: String,
    val phone: String?,
    val avatarUrl: String?,
    val signature: String?,
    val gender: String?,
    val lastOnline: Long?
) 