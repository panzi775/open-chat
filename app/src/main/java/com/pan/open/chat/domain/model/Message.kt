package com.pan.open.chat.domain.model

data class Message(
    val id: String,
    val senderId: String,
    val receiverId: String,
    val content: String,
    val type: MessageType,
    val timestamp: Long,
    val status: MessageStatus
)

enum class MessageType {
    TEXT, IMAGE, VOICE, VIDEO, FILE
}

enum class MessageStatus {
    SENDING, SENT, DELIVERED, READ
} 