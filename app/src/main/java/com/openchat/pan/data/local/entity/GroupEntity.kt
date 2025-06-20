package com.openchat.pan.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "groups")
data class GroupEntity(
    @PrimaryKey val id: String,
    val name: String,
    val avatarUrl: String?,
    val announcement: String?,
    val ownerId: String
) 