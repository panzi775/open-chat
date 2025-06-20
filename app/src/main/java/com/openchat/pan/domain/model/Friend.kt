package com.openchat.pan.domain.model

data class Friend(
    val id: String,
    val userId: String,
    val remark: String?,
    val group: String?
) 