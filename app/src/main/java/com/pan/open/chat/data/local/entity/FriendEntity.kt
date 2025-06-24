package com.pan.open.chat.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "friends")
data class FriendEntity(
    @PrimaryKey val id: String,
    val userId: String,
    val remark: String?,
    val group: String?
) 