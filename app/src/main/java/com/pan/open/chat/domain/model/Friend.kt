package com.pan.open.chat.domain.model

data class Friend(
    val id: String,
    val userId: String,
    val remark: String?,
    val group: String?
) 